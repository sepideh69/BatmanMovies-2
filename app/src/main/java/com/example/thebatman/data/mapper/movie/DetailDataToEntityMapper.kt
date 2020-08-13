package com.example.thebatman.data.mapper.movie

import com.example.thebatman.data.entities.DetailData
import com.example.thebatman.domain.common.Mapper
import com.example.thebatman.domain.entities.MovieDetailEntity
import com.example.thebatman.domain.entities.MovieEntity
import javax.inject.Inject

class DetailDataToEntityMapper @Inject constructor() : Mapper<DetailData, MovieEntity>() {
    override fun mapFrom(from: DetailData): MovieEntity {
        val movieEntity = MovieEntity(
            title = from.title,
            year = from.year,
            poster = from.poster,
            imdbID = from.imdbID,
            type = from.type


        )

        movieEntity.details = MovieDetailEntity(
            rated = from.rated,
            released = from.released,
            runtime = from.runtime,
            genre = from.genre,
            director = from.director,
            writer = from.writer,
            actors = from.actors,
            plot = from.plot,
            language = from.language,
            country = from.country,
            awards = from.awards,
            metascore = from.metascore,
            imdbRating = from.imdbRating,
            imdbVotes = from.imdbVotes,
            dVD = from.dVD,
            boxOffice = from.boxOffice,
            production = from.production,
            website = from.website,
            response = from.response
        )
        return movieEntity
    }
}