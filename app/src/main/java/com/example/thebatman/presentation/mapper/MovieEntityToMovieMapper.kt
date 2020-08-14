package com.example.thebatman.presentation.mapper

import com.example.thebatman.domain.common.Mapper
import com.example.thebatman.domain.entities.MovieEntity
import com.example.thebatman.presentation.entities.Movie
import javax.inject.Inject

class MovieEntityToMovieMapper @Inject constructor() : Mapper<MovieEntity, Movie>() {
    override fun mapFrom(from: MovieEntity): Movie {
        return Movie(
            title = from.title,
            year = from.year ,
            poster = from.poster ,
            imdbID = from.imdbID ,
            type = from.type ,
            details = from.details
        )
    }
}