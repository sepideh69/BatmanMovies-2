package com.example.thebatman.domain.usecase

import com.example.thebatman.domain.MovieCache
import com.example.thebatman.domain.common.Transformer
import com.example.thebatman.domain.entities.MovieEntity
import io.reactivex.Observable

class GetFavoritesUseCase(transformer: Transformer<List<MovieEntity>> , val movieCache: MovieCache) :UseCase<List<MovieEntity>>(transformer) {
    override fun createObservable(data: Map<String, Any>?): Observable<List<MovieEntity>> {
        return movieCache.getAll()
    }
}