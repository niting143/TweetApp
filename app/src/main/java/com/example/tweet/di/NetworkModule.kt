package com.example.tweet.di

import com.example.tweet.api.TweetsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitObject(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io/v3/").addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getTweetApi(retrofit: Retrofit) : TweetsApi{
        return retrofit.create(TweetsApi::class.java)
    }

}