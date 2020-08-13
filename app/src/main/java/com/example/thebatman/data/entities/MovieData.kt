package com.example.thebatman.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class MovieData (
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    @SerializedName("Poster") val poster: String,
    @PrimaryKey
    @SerializedName("imdbID") val imdbID: String,
    @SerializedName("Type") val type: String
)
