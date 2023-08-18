package com.harshbhatt.finalexam.JokeApiService

import com.harshbhatt.finalexam.model.JokeResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface JokeApiService {
    @Headers("Accept: application/json")
    @GET("/")
    suspend fun getRandomJoke(): JokeResponse
}
