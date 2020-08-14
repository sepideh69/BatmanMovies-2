package com.example.thebatman.data.db.favorites

import android.util.Log
import com.example.thebatman.data.entities.FavoriteData
import com.example.thebatman.domain.common.Mapper
import com.example.thebatman.domain.MovieCache
import com.example.thebatman.domain.entities.MovieEntity
import com.example.thebatman.domain.entities.Container
import io.reactivex.Observable

class RoomFavoriteCache(
    val dao: FavoriteDao
    , private val entityToFavoriteMapper: Mapper<MovieEntity, FavoriteData>,
    private val favoriteToEntityMapper: Mapper<FavoriteData, MovieEntity>
) : MovieCache {


    override fun clear() {
        dao.clear()
    }

    override fun save(movieEntity: MovieEntity) {
        dao.saveMovie(entityToFavoriteMapper.mapFrom(movieEntity))
    }

    override fun remove(movieEntity: MovieEntity) {
        dao.removeMovie(entityToFavoriteMapper.mapFrom(movieEntity))
    }

    override fun saveAll(movieEntities: List<MovieEntity>) {
        dao.saveAllMovies(movieEntities.map { entityToFavoriteMapper.mapFrom(it) })
    }

    override fun getAll(): Observable<List<MovieEntity>> {
        return Observable.fromCallable {
            dao.getMovies().map {
                favoriteToEntityMapper.mapFrom(it)
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
                Container.of(favoriteToEntityMapper.mapFrom(it))
            } ?: Container.empty()
        }

    }


}




