package com.example.thebatman.domain

import com.example.thebatman.domain.entities.MovieEntity
import io.reactivex.Observable

interface MovieRepository {

    fun getMovies() : Observable<List<MovieEntity>>
    fun search()
    fun getMovieById(movieId: String) : Observable<MovieEntity>
}