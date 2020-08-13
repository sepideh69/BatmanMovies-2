package com.example.thebatman.presentation.di.detail

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.thebatman.presentation.di.AppComponent
import com.example.thebatman.presentation.di.key.ViewModelKey
import com.example.thebatman.presentation.ui.detail.DetailViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap

@Module
abstract class DetailViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(detailViewModel: DetailViewModel):ViewModel



}