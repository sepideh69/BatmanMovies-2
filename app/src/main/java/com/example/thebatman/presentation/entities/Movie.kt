package com.example.thebatman.presentation.entities

import com.example.thebatman.domain.entities.MovieDetailEntity

data class Movie(
    val title: String,
    val year: String,
    val poster: String,
    val imdbID: String,
    val type: String,
    var details: MovieDetailEntity? = null,
    var isFavorite: Boolean =false
)

