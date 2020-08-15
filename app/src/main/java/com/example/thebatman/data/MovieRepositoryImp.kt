package com.example.thebatman.data

import android.util.Log
import com.example.thebatman.domain.MovieRepository
import com.example.thebatman.domain.entities.MovieEntity
import io.reactivex.Observable

class MovieRepositoryImp(
    val cacheMovieDataStore: CacheMovieDataStore,
    val remoteMovieDataStore: RemoteMovieDataStore
) : MovieRepository {

    override fun getMovies(): Observable<List<MovieEntity>> {
        return cacheMovieDataStore.isEmpty().flatMap {

            if(it){
                Log.d("eee","empty")
                return@flatMap remoteMovieDataStore.getMovies().doOnNext {
                    cacheMovieDataStore.saveAll(it)
                }.doOnError {
                    Log.d("dfd","getMoviesimp: $it")
                }
            }else{
                Log.d("eee","not empty")
                return@flatMap cacheMovieDataStore.getMovies()
            }
        }

    }

    override fun search() {
        TODO("Not yet implemented")
    }

    override fun getMovieById(movieId: String): Observable<MovieEntity> {
        return remoteMovieDataStore.getMovieById(movieId)
    }


}