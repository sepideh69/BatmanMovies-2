package com.example.thebatman.domain.usecase

import com.example.thebatman.domain.MovieRepository
import com.example.thebatman.domain.common.Transformer
import com.example.thebatman.presentation.common.ASyncTransformer
import io.reactivex.Observable
import io.reactivex.ObservableTransformer

abstract class UseCase<T> (val transformer : Transformer<T>) {

    abstract fun createObservable(data : Map<String , Any> ? = null) : Observable<T>

    fun setObservable (withData : Map<String,Any> ? =null): Observable<T>{
        return createObservable(withData).compose(transformer)
    }
}