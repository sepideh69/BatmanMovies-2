package com.example.thebatman.domain.usecase

import com.example.thebatman.domain.MovieRepository
import com.example.thebatman.domain.common.Transformer
import com.example.thebatman.domain.entities.MovieEntity
import io.reactivex.Observable

class GetDetailUseCase(
    transformer: Transformer<MovieEntity>,
    val movieRepository: MovieRepository
) : UseCase<MovieEntity>(transformer) {

    companion object {
        private const val PARAM_MOVIE_ENTITY = "param:movieEntity"
    }

    fun getId(movieId : String) : Observable<MovieEntity>{
        val data = HashMap<String,Any>()
        data[PARAM_MOVIE_ENTITY]= movieId
        return setObservable(data)
    }
    override fun createObservable(data: Map<String, Any>?): Observable<MovieEntity> {
        val id=data?.get(PARAM_MOVIE_ENTITY)
        return movieRepository.getMovieById(id as String)
    }
}