package com.example.thebatman.presentation.ui.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thebatman.domain.entities.MovieEntity
import com.example.thebatman.domain.usecase.GetMoviesUseCase
import com.example.thebatman.presentation.common.BaseViewModel
import com.example.thebatman.presentation.common.Result
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    val getMoviesUseCase: GetMoviesUseCase,
    compositeDisposable: CompositeDisposable
) : BaseViewModel(compositeDisposable) {


    val movieResult = MutableLiveData<Result<List<MovieEntity>>>()

    init {

        getMovies()
    }

    private fun getMovies() {


        movieResult.value= Result.loading()
        compositeDisposable.add(
            getMoviesUseCase.setObservable().subscribe(
                { response -> success(response) }, { t -> onFailure(t) }
            )
        )

    }


    private fun onFailure(t: Throwable) {
        Log.d("ert","onFailure  ${t.message}")
        movieResult.value= Result.error(t.message.toString())
    }

    private fun success(movies: List<MovieEntity>) {

        Log.d("ert","success")
        movieResult.value= Result.success(movies)
    }
}