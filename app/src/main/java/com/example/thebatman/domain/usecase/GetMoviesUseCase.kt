package com.example.thebatman.domain.usecase

import com.example.thebatman.domain.MovieRepository
import com.example.thebatman.domain.common.Transformer
import com.example.thebatman.domain.entities.MovieEntity
import io.reactivex.Observable

class GetMoviesUseCase(
    transformer: Transformer<List<MovieEntity>>
    ,val movieRepository: MovieRepository
) : UseCase<List<MovieEntity>>(transformer) {
    override fun createObservable(data: Map<String, Any>?): Observable<List<MovieEntity>> {
        return movieRepository.getMovies()
    }
}