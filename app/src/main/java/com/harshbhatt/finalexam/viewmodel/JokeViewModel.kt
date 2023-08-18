package com.harshbhatt.finalexam.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.harshbhatt.finalexam.repository.JokeRepository
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class JokeViewModel(private val repository: JokeRepository) : ViewModel() {

    companion object {
        private const val TAG = "JokeViewModel"
    }

    private val _joke = MutableLiveData<String>()
    val joke: LiveData<String>
        get() = _joke

    val isNetworkAvailable: LiveData<Boolean> = MutableLiveData(true)

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?>
        get() = _error

    fun setError(message: String) {
        _error.postValue(message)
    }

    fun clearError() {
        _error.postValue(null)
    }

    init {
        fetchRandomJoke()
    }

    fun fetchRandomJoke() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            try {
                if (isNetworkAvailable.value == true) {
                    val jokeResponse = repository.fetchRandomJoke()
                    Log.e(TAG, "fetchRandomJoke: ${jokeResponse.joke}")
                    _joke.postValue(jokeResponse.joke)
                } else {
                    fetchRandomJokeFromLocal()
                }
            }catch (e: UnknownHostException) {
                // Display offline joke
                fetchRandomJokeFromLocal()
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching joke: ${e.message}")
                //show snack bar with error message
                setError("Error fetching joke: ${e.message}")
                //_error.postValue("Error fetching joke: ${e.message}")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    fun fetchRandomJokeFromLocal() {
        viewModelScope.launch {
            val joke = repository.getRandomJokeFromLocal()
            _joke.postValue(joke)
            Log.e(TAG, "fetchRandomJokeFromLocal: $joke")
        }
    }
}

class JokeViewModelFactory(private val repository: JokeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JokeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return JokeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

