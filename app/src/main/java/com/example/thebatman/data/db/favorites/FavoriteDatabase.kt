package com.example.thebatman.data.db.favorites

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.thebatman.data.db.movies.MovieDao
import com.example.thebatman.data.entities.FavoriteData
import com.example.thebatman.data.entities.MovieData

@Database(entities = [FavoriteData::class], version = 1, exportSchema = false)
abstract class FavoriteDatabase : RoomDatabase() {

    abstract val favoriteDao: FavoriteDao
}