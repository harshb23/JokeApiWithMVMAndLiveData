package com.harshbhatt.finalexam.room_database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/harshbhatt/finalexam/room_database/JokeDatabase;", "Landroidx/room/RoomDatabase;", "()V", "jokeDao", "Lcom/harshbhatt/finalexam/room/JokeDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.harshbhatt.finalexam.room.JokeEntity.class}, version = 1)
public abstract class JokeDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.harshbhatt.finalexam.room_database.JokeDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.harshbhatt.finalexam.room_database.JokeDatabase.Companion Companion = null;
    
    public JokeDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.harshbhatt.finalexam.room.JokeDao jokeDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/harshbhatt/finalexam/room_database/JokeDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/harshbhatt/finalexam/room_database/JokeDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.harshbhatt.finalexam.room_database.JokeDatabase getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}