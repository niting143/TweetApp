package com.example.tweet.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweet.models.Tweet
import com.example.tweet.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(private val repository: TweetRepository,
    private val savedStateHandle: SavedStateHandle) : ViewModel() {


    val categoryDetail : StateFlow<List<Tweet>>
    get() = repository.tweetState


    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "Android"
            repository.getCategories(category)
        }
    }
}