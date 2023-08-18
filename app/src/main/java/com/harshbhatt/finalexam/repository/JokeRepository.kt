package com.harshbhatt.finalexam.repository

import com.harshbhatt.finalexam.JokeApiService.JokeApiService
import com.harshbhatt.finalexam.model.JokeResponse
import com.harshbhatt.finalexam.room.JokeDao
import com.harshbhatt.finalexam.room.JokeEntity

class JokeRepository(private val apiService: JokeApiService, private val jokeDao: JokeDao) {

    suspend fun fetchRandomJoke(): JokeResponse {
        val jokeResponse = apiService.getRandomJoke()
        jokeDao.insertJoke(JokeEntity(jokeResponse.id, jokeResponse.joke))
        return jokeResponse
    }

    suspend fun getRandomJokeFromLocal(): String {
        val jokeEntity = jokeDao.getRandomJoke()
        return jokeEntity?.joke ?: "No jokes available offline"
    }
}

