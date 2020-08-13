package com.example.thebatman.presentation.di

import android.content.Context
import com.example.thebatman.presentation.di.modules.*
import com.example.thebatman.utils.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, AppModule::class , DataModule::class ,RoomModule::class,ActivityBuilderModule::class, FragmentBuilderModule::class ]
)

interface AppComponent : AndroidInjector<BaseApplication>{

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun getContext(context: Context): Builder
        fun build(): AppComponent
    }
}