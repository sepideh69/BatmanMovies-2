package com.example.thebatman.presentation.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.thebatman.domain.common.Mapper
import com.example.thebatman.domain.entities.MovieEntity
import com.example.thebatman.domain.usecase.CheckFavoriteUseCase
import com.example.thebatman.domain.usecase.GetDetailUseCase
import com.example.thebatman.domain.usecase.RemoveFavoriteUseCase
import com.example.thebatman.domain.usecase.SaveFavoriteUseCase
import com.example.thebatman.presentation.common.BaseViewModel
import com.example.thebatman.presentation.common.Result
import com.example.thebatman.presentation.entities.Movie
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    val movieId: String,
    compositeDisposable: CompositeDisposable,
    val getMovieDetailUseCase: GetDetailUseCase,
    val checkFavoriteUseCase: CheckFavoriteUseCase,
    val saveFavoriteUseCase: SaveFavoriteUseCase,
    val removeFavoriteUseCase: RemoveFavoriteUseCase,
    val mapper: Mapper<MovieEntity, Movie>

) : BaseViewModel(compositeDisposable) {

    lateinit var theMovieEntity: MovieEntity
    val movieDetail = MutableLiveData<Result<Movie>>()
    var favoriteState = MutableLiveData<Boolean>()


    init {
        getDetail()
    }

    private fun getDetail() {

        movieDetail.value = Result.loading()
        compositeDisposable.add(
            getMovieDetailUseCase.getId(movieId).map {
                theMovieEntity = it
                mapper.mapFrom(it)
            }.zipWith(
                checkFavorite(movieId),
                BiFunction<Movie, Boolean, Movie> { movie, isFavorite ->
                    movie.isFavorite = isFavorite
                    return@BiFunction movie
                }).subscribe({ onMovieDetailsReceived(it) }, { onFailure(it) })
        )

    }

    private fun onFailure(throwable: Throwable) {
        Log.d("ewr", "onfail ${throwable.message}")
        movieDetail.value = Result.error(throwable.message.toString())

    }

    private fun onMovieDetailsReceived(movie: Movie) {
        Log.d("ewr", "onSuccess  ${movie}")
        movieDetail.value = Result.success(movie)
        favoriteState.value = movie.isFavorite
    }


    private fun checkFavorite(id: String): Observable<Boolean> {

        return checkFavoriteUseCase.checkFavorite(id)

    }


    fun onFavoriteButtonClicked() {
        compositeDisposable.add(checkFavorite(movieId).flatMap {

            when (it) {
                false -> {

                    saveFavorite(theMovieEntity)
                }
                true -> {

                    removeFavorite(theMovieEntity)
                }

            }
        }.subscribe({ response -> clickOnFavoriteIsDone(response) }, { t -> onFailure(t) })
        )

    }

    private fun clickOnFavoriteIsDone(boolean: Boolean) {

        Log.d("ewr", "bool: $boolean")
        favoriteState.value = boolean
    }

    private fun saveFavorite(movieEntity: MovieEntity): Observable<Boolean> {
        return saveFavoriteUseCase.saveFavorite(movieEntity)

    }

    fun removeFavorite(movieEntity: MovieEntity): Observable<Boolean> {

        return removeFavoriteUseCase.removeFavorite(movieEntity)
    }


}