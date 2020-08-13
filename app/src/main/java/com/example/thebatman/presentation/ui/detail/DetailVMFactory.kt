package com.example.thebatman.presentation.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thebatman.domain.usecase.GetDetailUseCase
import io.reactivex.disposables.CompositeDisposable

class DetailVMFactory(
    val compositeDisposable: CompositeDisposable,
    val getDetailUseCase: GetDetailUseCase

) : ViewModelProvider.Factory {

    var movieId: String = ""
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(
            movieId,
            compositeDisposable,
            getDetailUseCase

        ) as T
    }
}