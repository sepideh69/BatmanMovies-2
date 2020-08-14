package com.example.thebatman.domain

import com.example.thebatman.domain.entities.MovieEntity
import com.example.thebatman.domain.entities.Container
import io.reactivex.Observable

interface MovieCache {

    fun clear()
    fun save(movieEntity: MovieEntity)
    fun remove(movieEntity: MovieEntity)
    fun saveAll(movieEntities: List<MovieEntity>)
    fun getAll(): Observable<List<MovieEntity>>
    fun get(movieId: String): Observable<Container<MovieEntity>>
    fun search(query: String): Observable<List<MovieEntity>>
    fun isEmpty(): Observable<Boolean>
}