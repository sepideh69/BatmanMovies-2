package com.example.thebatman.presentation.di.favorites

import androidx.lifecycle.ViewModel
import com.example.thebatman.presentation.di.key.ViewModelKey
import com.example.thebatman.presentation.ui.favorits.FavoritesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FavoriteViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FavoritesViewModel::class)
    abstract fun bindFavoriteViewModel(favoritesViewModel: FavoritesViewModel): ViewModel
}