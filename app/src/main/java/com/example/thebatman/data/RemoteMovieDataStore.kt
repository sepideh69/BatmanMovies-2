package com.example.thebatman.data

import com.example.thebatman.data.api.Api
import com.example.thebatman.data.entities.DetailData
import com.example.thebatman.data.entities.MovieData
import com.example.thebatman.data.mapper.movie.DetailDataToEntityMapper
import com.example.thebatman.data.mapper.movie.MovieDataEntityMapper
import com.example.thebatman.domain.MovieRepository
import com.example.thebatman.domain.common.Mapper
import com.example.thebatman.domain.entities.MovieEntity
import com.example.thebatman.utils.Constants
import io.reactivex.Observable

class RemoteMovieDataStore(
    val api: Api, val movieDataEntityMapper:
    Mapper<MovieData, MovieEntity>, val detailDataToEntityMapper: Mapper<DetailData, MovieEntity>
) : MovieRepository {


    override fun getMovies(): Observable<List<MovieEntity>> {
        return api.getMovies(Constants.API_KEY, Constants.s).map {

            it.movieList.map {

                movieDataEntityMapper.mapFrom(it)
            }
        }
    }

    override fun search() {
        TODO("Not yet implemented")
    }

    override fun getMovieById(movieId: String): Observable<MovieEntity> {
        return api.getMovieById(Constants.API_KEY, movieId).map {
            detailDataToEntityMapper.mapFrom(it)
        }

    }
}