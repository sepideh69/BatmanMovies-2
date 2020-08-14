package com.example.thebatman.presentation.di.modules

import android.content.Context
import androidx.room.Room
import com.example.thebatman.data.db.favorites.FavoriteDao
import com.example.thebatman.data.db.favorites.FavoriteDatabase
import com.example.thebatman.data.db.movies.MovieDao
import com.example.thebatman.data.db.movies.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RoomModule {

    @Named("favorite_database_name")
    @Provides
    fun provideFavoritesDatabaseName(): String {
        return "favorites"

    }

    @Provides
    fun provideFavoriteDao(favoriteDatabase: FavoriteDatabase): FavoriteDao {
        return favoriteDatabase.favoriteDao
    }


    @Provides
    fun provideFavoriteDatabase(context: Context, @Named("favorite_database_name") dbName: String): FavoriteDatabase {
        return Room.databaseBuilder(context, FavoriteDatabase::class.java, dbName)
            .fallbackToDestructiveMigration().build()
    }

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