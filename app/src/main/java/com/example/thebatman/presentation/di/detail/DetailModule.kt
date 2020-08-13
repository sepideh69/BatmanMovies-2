package com.example.thebatman.presentation.di.detail

import com.example.thebatman.domain.MovieRepository
import com.example.thebatman.domain.MoviesCache
import com.example.thebatman.domain.usecase.GetDetailUseCase
import com.example.thebatman.presentation.common.ASyncTransformer
import com.example.thebatman.presentation.ui.detail.DetailVMFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class DetailModule {



    @Provides
    fun provideGetDetailUseCase(movieRepository: MovieRepository): GetDetailUseCase {
        return GetDetailUseCase(ASyncTransformer(), movieRepository)
    }


    @Provides
    fun provideDetailVMFactory(
        compositeDisposable: CompositeDisposable,
        getDetailUseCase: GetDetailUseCase

    ): DetailVMFactory {
        return DetailVMFactory(compositeDisposable, getDetailUseCase)
    }
}