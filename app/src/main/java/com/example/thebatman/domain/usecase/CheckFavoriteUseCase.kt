package com.example.thebatman.domain.usecase

import com.example.thebatman.domain.MovieCache
import com.example.thebatman.domain.common.Transformer
import io.reactivex.Observable
import java.lang.IllegalArgumentException

class CheckFavoriteUseCase(transformer: Transformer<Boolean>, val movieCache: MovieCache) :
    UseCase<Boolean>(transformer) {

    companion object {
        private const val MOVIE_ID = "movieId"

    }

    fun checkFavorite(movieId: String): Observable<Boolean> {
        val data = HashMap<String, Any>()
        data[MOVIE_ID] = movieId
        return setObservable(data)
    }

    override fun createObservable(data: Map<String, Any>?): Observable<Boolean> {
        val any = data?.get(MOVIE_ID)
        any?.let {
            val id = any as String
            return movieCache.get(id).flatMap {
                return@flatMap Observable.fromCallable {
                    it.hasValue()
                }
            }
        } ?: return Observable.error({ IllegalArgumentException("MovieId must be provided.") }
        )
    }
}