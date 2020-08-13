package com.example.thebatman.presentation.di.modules

import com.example.thebatman.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {


    @ContributesAndroidInjector
    abstract fun contributeMainActivity():MainActivity
}