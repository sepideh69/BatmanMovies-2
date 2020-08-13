package com.example.thebatman.presentation.di.movies

import com.example.thebatman.domain.MovieRepository
import com.example.thebatman.domain.usecase.GetMoviesUseCase
import com.example.thebatman.presentation.common.ASyncTransformer
import dagger.Module
import dagger.Provides

@Module
 class MoviesModule {

 @MoviesScope
 @Provides
 fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
  return GetMoviesUseCase(ASyncTransformer(),movieRepository)
 }
}