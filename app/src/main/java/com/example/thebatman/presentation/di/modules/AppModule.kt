package com.example.thebatman.presentation.di.modules

import com.example.thebatman.data.api.Api
import com.example.thebatman.utils.Constants
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(@Named("baseURL") baseUrl : String, rxJava2CallAdapterFactory: RxJava2CallAdapterFactory, converter: GsonConverterFactory) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .addConverterFactory(converter)
            .build()
    }


    @Singleton
    @Provides
    fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun provideGSONConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    @Named("baseURL")
    fun provideBaseURL(): String {
        return Constants.BASE_URL
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit) : Api{
        return retrofit.create(Api::class.java)
    }

    @Provides
    fun getCompositeDisposable() : CompositeDisposable {
        return CompositeDisposable()
    }


}