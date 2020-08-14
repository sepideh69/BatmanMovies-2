package com.example.thebatman.presentation.di.detail

import com.example.thebatman.domain.MovieRepository
import com.example.thebatman.domain.MovieCache
import com.example.thebatman.domain.common.Mapper
import com.example.thebatman.domain.usecase.CheckFavoriteUseCase
import com.example.thebatman.domain.usecase.GetDetailUseCase
import com.example.thebatman.domain.usecase.RemoveFavoriteUseCase
import com.example.thebatman.domain.usecase.SaveFavoriteUseCase
import com.example.thebatman.presentation.common.ASyncTransformer
import com.example.thebatman.presentation.mapper.MovieEntityToMovieMapper
import com.example.thebatman.presentation.ui.detail.DetailVMFactory
import com.example.thebatman.utils.Constants
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Named

@Module
class DetailModule {


    @Provides
    fun provideRemoveFavoriteUseCase(@Named(Constants.favoritesCache) moviesCache: MovieCache): RemoveFavoriteUseCase {
        return RemoveFavoriteUseCase(ASyncTransformer(), moviesCache)
    }

    @Provides
    fun provideSaveFavoriteUseCase(@Named(Constants.favoritesCache) moviesCache: MovieCache): SaveFavoriteUseCase {
        return SaveFavoriteUseCase(ASyncTransformer(), moviesCache)
    }

    @Provides
    fun provideCheckFavoriteUseCase(@Named(Constants.favoritesCache) moviesCache: MovieCache): CheckFavoriteUseCase {
        return CheckFavoriteUseCase(ASyncTransformer(), moviesCache)
    }

    @Provides
    fun provideGetDetailUseCase(movieRepository: MovieRepository): GetDetailUseCase {
        return GetDetailUseCase(ASyncTransformer(), movieRepository)
    }


    @Provides
    fun provideDetailVMFactory(
        compositeDisposable: CompositeDisposable,
        getDetailUseCase: GetDetailUseCase,
        checkFavoriteUseCase: CheckFavoriteUseCase,
        saveFavoriteUseCase: SaveFavoriteUseCase,
        removeFavoriteUseCase: RemoveFavoriteUseCase ,
        mapper : MovieEntityToMovieMapper

    ): DetailVMFactory {
        return DetailVMFactory(compositeDisposable, getDetailUseCase , checkFavoriteUseCase,saveFavoriteUseCase,removeFavoriteUseCase,mapper)
    }
}