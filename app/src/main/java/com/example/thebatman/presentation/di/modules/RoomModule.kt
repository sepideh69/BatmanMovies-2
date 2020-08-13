package com.example.thebatman.presentation.di.modules

import android.content.Context
import androidx.room.Room
import com.example.thebatman.data.db.movies.MovieDao
import com.example.thebatman.data.db.movies.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RoomModule {



    @Provides
    fun provideDao(movieDatabase: MovieDatabase): MovieDao {
        return movieDatabase.movieDao
    }

    @Provides
    fun provideDatabase(context: Context, @Named("database_name") dbName: String): MovieDatabase {
        return Room.databaseBuilder(context, MovieDatabase::class.java, dbName)
            .fallbackToDestructiveMigration().build()
    }


    @Named("database_name")
    @Provides
    fun provideDatabaseName(): String {
        return "movies"

    }

}