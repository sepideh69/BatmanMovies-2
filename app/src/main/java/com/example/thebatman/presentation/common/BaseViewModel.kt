package com.example.thebatman.presentation.common

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class BaseViewModel @Inject constructor(val compositeDisposable: CompositeDisposable) : ViewModel() {

    private fun clearDisposables() {
        compositeDisposable.clear()
    }
    override fun onCleared() {
        clearDisposables()
    }
}