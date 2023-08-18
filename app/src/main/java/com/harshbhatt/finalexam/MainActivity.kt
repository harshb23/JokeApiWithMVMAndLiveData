package com.harshbhatt.finalexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.harshbhatt.finalexam.JokeApiService.JokeApiService
import com.harshbhatt.finalexam.repository.JokeRepository
import com.harshbhatt.finalexam.retrofit_client.RetrofitClient
import com.harshbhatt.finalexam.room_database.JokeDatabase
import com.harshbhatt.finalexam.viewmodel.JokeViewModel
import com.harshbhatt.finalexam.viewmodel.JokeViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var jokeTextView: TextView
    private lateinit var nextJokeButton: Button
    private lateinit var progressBar: ProgressBar

    private lateinit var viewModel: JokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jokeTextView = findViewById(R.id.joke)
        nextJokeButton = findViewById(R.id.btnNextJoke)
        progressBar = findViewById(R.id.progressBar)

        val apiService = RetrofitClient.createService(JokeApiService::class.java)
        val database = JokeDatabase.getInstance(applicationContext)
        val repository = JokeRepository(apiService, database.jokeDao())
        viewModel = ViewModelProvider(this, JokeViewModelFactory(repository)).get(JokeViewModel::class.java)

        viewModel.joke.observe(this) { joke ->
            jokeTextView.text = joke
        }

        viewModel.isLoading.observe(this) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.isNetworkAvailable.observe(this) { isNetworkAvailable ->
            if (!isNetworkAvailable) {
                showOfflineJoke()
            }
        }

        viewModel.error.observe(this) { errorMessage ->
            if (errorMessage != null) {
                showSnackbar(errorMessage)
                viewModel.clearError()
            }
        }

        nextJokeButton.setOnClickListener {
            viewModel.fetchRandomJoke()
        }
    }

    private fun showOfflineJoke() {
        viewModel.fetchRandomJokeFromLocal()
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }
}