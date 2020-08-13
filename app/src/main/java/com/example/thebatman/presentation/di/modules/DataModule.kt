package com.example.thebatman.presentation.di.modules

import com.example.thebatman.data.CacheMovieDataStore
import com.example.thebatman.data.MovieRepositoryImp
import com.example.thebatman.data.RemoteMovieDataStore
import com.example.thebatman.data.api.Api
import com.example.thebatman.data.db.movies.MovieDao
import com.example.thebatman.data.db.movies.RoomMovieCache
import com.example.thebatman.data.mapper.movie.DetailDataToEntityMapper
import com.example.thebatman.data.mapper.movie.MovieDataEntityMapper
import com.example.thebatman.data.mapper.movie.MovieEntityDataMapper
import com.example.thebatman.domain.MovieRepository
import com.example.thebatman.domain.MoviesCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {


    @Singleton
    @Provides
    fun provideMovieCache(
        dao: MovieDao,
        entityDataMapper: MovieEntityDataMapper,
        dataEntityMapper: MovieDataEntityMapper
    ): MoviesCache {
        return RoomMovieCache(
            dao,
            entityDataMapper,
            dataEntityMapper
        )
    }

    @Singleton
    @Provides
    fun provideCachedMoviesDataStore(moviesCache: MoviesCache): CacheMovieDataStore {
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