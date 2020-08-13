package com.example.thebatman.data.mapper.favorite

import com.example.thebatman.data.entities.FavoriteData
import com.example.thebatman.data.entities.MovieData
import com.example.thebatman.domain.common.Mapper
import com.example.thebatman.domain.entities.MovieEntity
import javax.inject.Inject

class MovieEntityFavoriteMapper @Inject constructor(): Mapper<MovieEntity, FavoriteData>() {
    override fun mapFrom(from: MovieEntity): FavoriteData {
        return FavoriteData(
            title = from.title ,
            year = from.year,
            poster=from.poster,
            imdbID=from.imdbID,
            type=from.type

        )
    }
}