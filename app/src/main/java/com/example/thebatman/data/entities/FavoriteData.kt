package com.example.thebatman.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Favorites")
data class FavoriteData(
    val title: String,
    val year: String,
    val poster: String,
    @PrimaryKey
    val imdbID: String,
    val type: String
)
