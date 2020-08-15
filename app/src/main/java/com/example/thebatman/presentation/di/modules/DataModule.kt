package com.example.thebatman.presentation.di.modules

import androidx.lifecycle.ViewModel
import com.example.thebatman.data.CacheMovieDataStore
import com.example.thebatman.data.MovieRepositoryImp
import com.example.thebatman.data.RemoteMovieDataStore
import com.example.thebatman.data.api.Api
import com.example.thebatman.data.db.favorites.FavoriteDao
import com.example.thebatman.data.db.favorites.RoomFavoriteCache
import com.example.thebatman.data.db.movies.MovieDao
import com.example.thebatman.data.db.movies.RoomMovieCache
import com.example.thebatman.data.mapper.favorite.FavoriteDataToEntityMapper
import com.example.thebatman.data.mapper.favorite.MovieEntityToFavoriteDataMapper
import com.example.thebatman.data.mapper.movie.DetailDataToEntityMapper
import com.example.thebatman.data.mapper.movie.MovieDataEntityMapper
import com.example.thebatman.data.mapper.movie.MovieEntityDataMapper
import com.example.thebatman.domain.MovieRepository
import com.example.thebatman.domain.MovieCache
import com.example.thebatman.presentation.di.key.ViewModelKey
import com.example.thebatman.presentation.ui.main.MainViewModel
import com.example.thebatman.utils.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Named
import javax.inject.Singleton

@Module
class DataModule {


    @Singleton
    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
     fun bindMainViewModel(): ViewModel {
        return MainViewModel()

    }

    @Singleton
    @Provides
    @Named(Constants.favoritesCache)
    fun provideFavoriteMovieCache(
        dao: FavoriteDao,
        movieEntityToFavoriteDataMapper: MovieEntityToFavoriteDataMapper,
        favoriteDataToEntityMapper: FavoriteDataToEntityMapper
    ): MovieCache {
        return RoomFavoriteCache(dao, movieEntityToFavoriteDataMapper, favoriteDataToEntityMapper)
    }

    @Singleton
    @Provides
    @Named(Constants.movieListCache)
    fun provideMovieCache(
        dao: MovieDao,
        entityDataMapper: MovieEntityDataMapper,
        dataEntityMapper: MovieDataEntityMapper
    ): MovieCache {
        return RoomMovieCache(
            dao,
            entityDataMapper,
            dataEntityMapper
        )
    }

    @Singleton
    @Provides
    fun provideCachedMoviesDataStore(@Named(Constants.movieListCache) moviesCache: MovieCache): CacheMovieDataStore {
        return CacheMovieDataStore(moviesCache)
    }

    @Singleton
    @Provides
    fun provideRemoteMoviesDataStore(
        api: Api, movieDataEntityMapper: MovieDataEntityMapper,
        detailDataToEntityMapper: DetailDataToEntityMapper
    ): RemoteMovieDataStore {
        return RemoteMovieDataStore(api, movieDataEntityMapper, detailDataToEntityMapper)
    }


    @Singleton
    @Provides
    fun provideMoviesRepository(
        cachedMoviesDataStore: CacheMovieDataStore,
        remoteMoviesDataStore: RemoteMovieDataStore
    ): MovieRepository {
        return MovieRepositoryImp(cachedMoviesDataStore, remoteMoviesDataStore)
    }


}