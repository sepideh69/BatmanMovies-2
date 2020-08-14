package com.example.thebatman.presentation.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thebatman.domain.common.Mapper
import com.example.thebatman.domain.entities.MovieEntity
import com.example.thebatman.domain.usecase.CheckFavoriteUseCase
import com.example.thebatman.domain.usecase.GetDetailUseCase
import com.example.thebatman.domain.usecase.RemoveFavoriteUseCase
import com.example.thebatman.domain.usecase.SaveFavoriteUseCase
import com.example.thebatman.presentation.entities.Movie
import io.reactivex.disposables.CompositeDisposable

class DetailVMFactory(
    val compositeDisposable: CompositeDisposable,
    val getDetailUseCase: GetDetailUseCase,
    val checkFavoriteUseCase: CheckFavoriteUseCase,
    val saveFavoriteUseCase: SaveFavoriteUseCase,
    val removeFavoriteUseCase: RemoveFavoriteUseCase ,
    val mapper:Mapper<MovieEntity,Movie>

) : ViewModelProvider.Factory {

    var movieId: String = ""
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(
            movieId,
            compositeDisposable,
            getDetailUseCase,
            checkFavoriteUseCase,
            saveFavoriteUseCase,
            removeFavoriteUseCase,
            mapper

        ) as T
    }
}