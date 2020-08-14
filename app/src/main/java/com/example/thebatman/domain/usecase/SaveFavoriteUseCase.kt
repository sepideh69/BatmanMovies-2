package com.example.thebatman.domain.usecase

import com.example.thebatman.domain.MovieCache
import com.example.thebatman.domain.common.Transformer
import com.example.thebatman.domain.entities.MovieEntity
import io.reactivex.Observable
import java.lang.IllegalArgumentException

class SaveFavoriteUseCase(transformer: Transformer<Boolean>,val moviesCache: MovieCache) :
    UseCase<Boolean>(transformer) {

    companion object {
        private const val MOVIE_ENTITY = "movieEntity"
    }

    fun saveFavorite(movieEntity: MovieEntity) : Observable<Boolean>{
        val data=HashMap<String , Any>()
        data[MOVIE_ENTITY]=movieEntity
        return setObservable(data)
    }

    override fun createObservable(data: Map<String, Any>?): Observable<Boolean> {

        val movieEntity = data?.get(MOVIE_ENTITY)
        return movieEntity?.let {
            Observable.fromCallable {
                val entity = it as MovieEntity
                moviesCache.save(entity)
                return@fromCallable true
            }

        }?: return Observable.error({ IllegalArgumentException("MovieEntity must be provided.") })

    }


}