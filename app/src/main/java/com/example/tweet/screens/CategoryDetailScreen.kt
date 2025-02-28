package com.example.tweet.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweet.R
import com.example.tweet.models.Tweet
import com.example.tweet.viewmodels.CategoryDetailViewModel


@Composable
fun CateggoryDetailsView(){
    val tweets: CategoryDetailViewModel = viewModel()
    val tweetsStaet: State<List<Tweet>> = tweets.categoryDetail.collectAsState()

    LazyColumn (content = {
        items(tweetsStaet.value){
            CategoryListItemView(tweet = it.tweet)
        }
    })

}
@Composable
fun CategoryListItemView(tweet:String){

    Card (Modifier.fillMaxWidth().
    padding(15.dp,10.dp), elevation = CardDefaults.cardElevation(4.dp),){
        Text(text = tweet, modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(R.font.montserratbold))
        )
    }

}