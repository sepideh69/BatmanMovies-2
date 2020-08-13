package com.example.thebatman.data

import com.example.thebatman.domain.MovieRepository
import com.example.thebatman.domain.MoviesCache
import com.example.thebatman.domain.entities.MovieEntity
import io.reactivex.Observable

class CacheMovieDataStore (val moviesCache: MoviesCache) :MovieRepository {
    override fun getMovies(): Observable<List<MovieEntity>> {
        return moviesCache.getAll()
    }

    override fun search() {
        TODO("Not yet implemented")
    }

    override fun getMovieById(movieId: String): Observable<MovieEntity> {
        TODO("Not yet implemented")
    }

    fun isEmpty(): Observable<Boolean> {
        return moviesCache.isEmpty()
    }

    fun saveAll(movieEntities: List<MovieEntity>) {
        moviesCache.saveAll(movieEntities)
    }
}