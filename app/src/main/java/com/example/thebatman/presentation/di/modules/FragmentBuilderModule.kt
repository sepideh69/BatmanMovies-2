package com.example.thebatman.presentation.di.modules

import com.example.thebatman.presentation.di.detail.DetailModule
import com.example.thebatman.presentation.di.favorites.FavoriteViewModelModule
import com.example.thebatman.presentation.di.favorites.FavoritesModule
import com.example.thebatman.presentation.di.movies.MoviesModule
import com.example.thebatman.presentation.di.movies.MoviesScope
import com.example.thebatman.presentation.di.movies.MoviesViewModelModule
import com.example.thebatman.presentation.ui.detail.DetailFragment
import com.example.thebatman.presentation.ui.favorits.FavoritesFragment
import com.example.thebatman.presentation.ui.movies.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {


    @ContributesAndroidInjector(modules = [FavoriteViewModelModule::class,FavoritesModule::class])
    abstract fun contributeFavoriteListFragment() : FavoritesFragment

    @MoviesScope
    @ContributesAndroidInjector(modules = [MoviesViewModelModule::class,MoviesModule::class])
    abstract fun contributeMoviesFragment() : MoviesFragment

    @ContributesAndroidInjector(modules = [DetailModule::class])
    abstract fun contributeDetailFragment() : DetailFragment
}