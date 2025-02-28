package com.example.tweet.repository

import com.example.tweet.api.TweetsApi
import com.example.tweet.models.Tweet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsApi: TweetsApi) {
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categoryState : StateFlow<List<String>>
    get() = _categories

    private val  _tweets = MutableStateFlow<List<Tweet>>(emptyList())
    val tweetState : StateFlow<List<Tweet>>
    get() = _tweets

    suspend fun getCategories(){
        val response = tweetsApi.getCategory()
        if (response.isSuccessful && response.body()!=null){
                _categories.emit(response.body()!!)
        }
    }

    suspend fun getCategories(category: String){
        val response = tweetsApi.getCategoryTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body()!=null){
            _tweets.emit(response.body()!!)
        }
    }
}