package com.example.thebatman.data.db.favorites

import androidx.room.*
import com.example.thebatman.data.entities.FavoriteData
import com.example.thebatman.data.entities.MovieData

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorites")
    fun getMovies(): List<FavoriteData>

    @Query("SELECT * FROM favorites WHERE imdbID=:movieId")
    fun get(movieId: String): FavoriteData?

    @Query("SELECT * FROM favorites WHERE title LIKE :query")
    fun search(query: String): List<FavoriteData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovie(movie: FavoriteData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllMovies(movies: List<FavoriteData>)

    @Delete
    fun removeMovie(movie: FavoriteData)

    @Query("DELETE FROM favorites")
    fun clear()
}