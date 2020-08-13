package com.example.thebatman.data.api

import com.example.thebatman.data.entities.DetailData
import com.example.thebatman.data.entities.MovieData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET(".")
    fun getMovies(
        @Query("apikey") apikey: String,
        @Query("s") name: String
    ): Observable<MovieListNetworkResult>

    @GET(".")
    fun getMovieById(
        @Query("apikey") apikey: String,
        @Query("i") movieId : String

    ): Observable<DetailData>
}