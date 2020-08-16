package com.example.thebatman.presentation.ui.favorits

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.thebatman.domain.entities.MovieEntity
import com.example.thebatman.domain.usecase.GetFavoritesUseCase
import com.example.thebatman.presentation.common.BaseViewModel
import com.example.thebatman.presentation.common.Result
import com.example.thebatman.presentation.entities.Movie
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(
    compositeDisposable: CompositeDisposable
    , val getFavoritesUseCase: GetFavoritesUseCase
) : BaseViewModel(compositeDisposable) {


    val favoritesResult = MutableLiveData<Result<List<MovieEntity>>>()

    init {
        getFavorites()
    }

    private fun getFavorites(){
        favoritesResult.value = Result.loading()

        compositeDisposable.add(
            getFavoritesUseCase.setObservable().subscribe({favoritesReceived(it)},{onError(it)})
        )
    }

    private fun favoritesReceived(response : List<MovieEntity>){
        favoritesResult.value=Result.success(response)

    }

    private fun onError(t:Throwable){
        Log.d("ert","error: ${t.message}")
        favoritesResult.value= Result.error(t.message.toString())

    }
}