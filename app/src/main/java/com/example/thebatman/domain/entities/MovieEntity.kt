package com.example.thebatman.domain.entities

data class MovieEntity (
    val title: String ,
    val year: String,
    val poster: String,
    val imdbID: String,
    val type: String,
    var details : MovieDetailEntity?=null

)
