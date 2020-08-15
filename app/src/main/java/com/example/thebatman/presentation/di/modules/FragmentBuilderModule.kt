package com.example.thebatman.presentation.di.modules

import com.example.thebatman.presentation.di.detail.DetailModule
import com.example.thebatman.presentation.di.detail.DetailScope
import com.example.thebatman.presentation.di.detail.DetailViewModelModule
import com.example.thebatman.presentation.di.movies.MoviesModule
import com.example.thebatman.presentation.di.movies.MoviesScope
import com.example.thebatman.presentation.di.movies.MoviesViewModelModule
import com.example.thebatman.presentation.ui.detail.DetailFragment
import com.example.thebatman.presentation.ui.favorits.FavoritesFragment
import com.example.thebatman.presentation.ui.movies.MoviesFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {


    @ContributesAndroidInjector()
    abstract fun contributeFavoritesFragment():FavoritesFragment


    @MoviesScope
    @ContributesAndroidInjector(modules = [MoviesViewModelModule::class,MoviesModule::class])
    abstract fun contributeMoviesFragment() : MoviesFragment

    @DetailScope
    @ContributesAndroidInjector(modules = [DetailViewModelModule::class , DetailModule::class])
    abstract fun contributeDetailFragment() : DetailFragment
}