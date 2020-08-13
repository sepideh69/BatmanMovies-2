package com.example.thebatman.data.mapper.movie

import com.example.thebatman.data.entities.MovieData
import com.example.thebatman.domain.common.Mapper
import com.example.thebatman.domain.entities.MovieEntity
import javax.inject.Inject

class MovieDataEntityMapper @Inject constructor() : Mapper<MovieData, MovieEntity>() {


    override fun mapFrom(from: MovieData): MovieEntity {
        return MovieEntity(
            title = from.title ,
            year = from.year,
            poster=from.poster,
            imdbID=from.imdbID,
            type=from.type

        )
    }
}