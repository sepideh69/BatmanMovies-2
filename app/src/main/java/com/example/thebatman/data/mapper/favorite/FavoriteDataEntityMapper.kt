package com.example.thebatman.data.mapper.favorite

import com.example.thebatman.data.entities.FavoriteData
import com.example.thebatman.data.entities.MovieData
import com.example.thebatman.domain.common.Mapper
import com.example.thebatman.domain.entities.MovieEntity
import javax.inject.Inject

class FavoriteDataEntityMapper @Inject constructor() : Mapper<FavoriteData, MovieEntity>() {


    override fun mapFrom(from: FavoriteData): MovieEntity {
        return MovieEntity(
            title = from.title ,
            year = from.year,
            poster=from.poster,
            imdbID=from.imdbID,
            type=from.type

        )
    }

}