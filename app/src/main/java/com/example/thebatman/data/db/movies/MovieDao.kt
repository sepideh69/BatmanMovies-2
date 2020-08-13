package com.example.thebatman.data.db.movies

import androidx.room.*
import com.example.thebatman.data.entities.MovieData

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getMovies(): List<MovieData>

    @Query("SELECT * FROM movies WHERE imdbID=:movieId")
    fun get(movieId: String): MovieData?

    @Query("SELECT * FROM movies WHERE title LIKE :query")
    fun search(query: String): List<MovieData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovie(movie: MovieData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllMovies(movies: List<MovieData>)

    @Delete
    fun removeMovie(movie: MovieData)

    @Query("DELETE FROM movies")
    fun clear()
}