package com.example.thebatman.data.db.movies

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.thebatman.data.db.movies.MovieDao
import com.example.thebatman.data.entities.MovieData

@Database(entities = [MovieData::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase(){

    abstract val movieDao: MovieDao
}