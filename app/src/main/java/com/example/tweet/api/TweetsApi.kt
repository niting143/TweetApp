package com.example.tweet.api

import com.example.tweet.models.Tweet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsApi {

    @GET("/v3/b/67bd8273e41b4d34e49babc1?meta=false")
    suspend fun getCategoryTweets(@Header("X-JSON-Path") categories: String): Response<List<Tweet>>

    @GET("/v3/b/67bd8273e41b4d34e49babc1?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategory(): Response<List<String>>
}