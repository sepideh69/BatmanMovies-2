package com.example.thebatman.presentation.di.movies

import androidx.lifecycle.ViewModel
import com.example.thebatman.presentation.di.key.ViewModelKey
import com.example.thebatman.presentation.ui.movies.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MoviesViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindMoviesViewModel(moviesViewModel: MoviesViewModel): ViewModel
}