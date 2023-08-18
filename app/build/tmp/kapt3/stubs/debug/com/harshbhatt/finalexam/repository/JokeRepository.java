package com.harshbhatt.finalexam.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/harshbhatt/finalexam/repository/JokeRepository;", "", "apiService", "Lcom/harshbhatt/finalexam/JokeApiService/JokeApiService;", "jokeDao", "Lcom/harshbhatt/finalexam/room/JokeDao;", "(Lcom/harshbhatt/finalexam/JokeApiService/JokeApiService;Lcom/harshbhatt/finalexam/room/JokeDao;)V", "fetchRandomJoke", "Lcom/harshbhatt/finalexam/model/JokeResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRandomJokeFromLocal", "", "app_debug"})
public final class JokeRepository {
    @org.jetbrains.annotations.NotNull
    private final com.harshbhatt.finalexam.JokeApiService.JokeApiService apiService = null;
    @org.jetbrains.annotations.NotNull
    private final com.harshbhatt.finalexam.room.JokeDao jokeDao = null;
    
    public JokeRepository(@org.jetbrains.annotations.NotNull
    com.harshbhatt.finalexam.JokeApiService.JokeApiService apiService, @org.jetbrains.annotations.NotNull
    com.harshbhatt.finalexam.room.JokeDao jokeDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object fetchRandomJoke(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.harshbhatt.finalexam.model.JokeResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRandomJokeFromLocal(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
}