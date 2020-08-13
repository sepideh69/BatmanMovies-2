package com.example.thebatman.data.mapper.movie

import com.example.thebatman.data.entities.MovieData
import com.example.thebatman.domain.common.Mapper
import com.example.thebatman.domain.entities.MovieEntity
import javax.inject.Inject

class MovieEntityDataMapper @Inject constructor(): Mapper<MovieEntity, MovieData>() {
    override fun mapFrom(from: MovieEntity): MovieData {
        return MovieData(
            title = from.title ,
            year = from.year,
            poster=from.poster,
            imdbID=from.imdbID,
            type=from.type

        )
    }
}