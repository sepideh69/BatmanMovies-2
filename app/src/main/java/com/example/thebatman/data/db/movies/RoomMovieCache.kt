package com.example.thebatman.data.db.movies

import android.util.Log
import com.example.thebatman.data.entities.MovieData
import com.example.thebatman.domain.common.Mapper
import com.example.thebatman.domain.MoviesCache
import com.example.thebatman.domain.entities.MovieEntity
import com.example.thebatman.domain.entities.Container
import io.reactivex.Observable

class RoomMovieCache(
    val dao: MovieDao
    , private val entityToDataMapper: Mapper<MovieEntity, MovieData>,
    private val dataToEntityMapper: Mapper<MovieData, MovieEntity>
) : MoviesCache {


    override fun clear() {
        dao.clear()
    }

    override fun save(movieEntity: MovieEntity) {
        dao.saveMovie(entityToDataMapper.mapFrom(movieEntity))
    }

    override fun remove(movieEntity: MovieEntity) {
        dao.removeMovie(entityToDataMapper.mapFrom(movieEntity))
    }

    override fun saveAll(movieEntities: List<MovieEntity>) {
        dao.saveAllMovies(movieEntities.map { entityToDataMapper.mapFrom(it) })
    }

    override fun getAll(): Observable<List<MovieEntity>> {
        return Observable.fromCallable {
            dao.getMovies().map {
                dataToEntityMapper.mapFrom(it)
            }
        }
    }

    override fun search(query: String): Observable<List<MovieEntity>> {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Observable<Boolean> {
        return Observable.fromCallable {
            Log.d("eee", "RoomMovieCache isEmpty ${Thread.currentThread().name}")
            dao.getMovies().isEmpty()
        }
    }




    override fun get(movieId: String): Observable<Container<MovieEntity>> {

        return Observable.fromCallable {
            val movieData = dao.get(movieId)
            movieData?.let {
                Container.of(dataToEntityMapper.mapFrom(it))
            } ?: Container.empty()
        }

    }

}


