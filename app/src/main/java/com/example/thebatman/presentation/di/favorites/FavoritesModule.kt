package com.example.thebatman.presentation.di.favorites

import com.example.thebatman.domain.MovieCache
import com.example.thebatman.domain.usecase.GetFavoritesUseCase
import com.example.thebatman.presentation.common.ASyncTransformer
import com.example.thebatman.utils.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class FavoritesModule {

    @Provides
    fun provideGetFavoritesUseCase(@Named(Constants.favoritesCache) movieCache: MovieCache): GetFavoritesUseCase {
        return GetFavoritesUseCase(ASyncTransformer(), movieCache)
    }
}