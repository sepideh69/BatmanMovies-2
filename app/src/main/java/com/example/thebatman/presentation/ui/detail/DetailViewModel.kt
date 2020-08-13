package com.example.thebatman.presentation.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.thebatman.domain.entities.MovieEntity
import com.example.thebatman.domain.usecase.GetDetailUseCase
import com.example.thebatman.presentation.common.BaseViewModel
import com.example.thebatman.presentation.common.Result
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    val movieId: String,
    compositeDisposable: CompositeDisposable,
    val getMovieDetailUseCase: GetDetailUseCase

) : BaseViewModel(compositeDisposable) {

    lateinit var theMovieEntity: MovieEntity
    val movieDetail = MutableLiveData<Result<MovieEntity>>()
    var favoriteState = MutableLiveData<Boolean>()


    init {
        getDetail()
       // checkFavorite()
    }

    private fun getDetail() {

        movieDetail.value = Result.loading()
        compositeDisposable.add(
            getMovieDetailUseCase.getId(movieId).subscribe(
                { response -> onMovieDetailsReceived(response) }, { t -> onFailure(t) }
            )
        )

    }

    private fun onFailure(throwable: Throwable) {
        Log.d("ert", "onfail ${throwable.message.toString()}")
        movieDetail.value = Result.error(throwable.message.toString())

    }

    private fun onMovieDetailsReceived(movieEntity: MovieEntity) {
        Log.d("eee", "onSuccess  ${movieEntity}")
        theMovieEntity = movieEntity
        movieDetail.value = Result.success(movieEntity)
    }




}