package com.example.tweet

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweet.screens.CateggoryDetailsView
import com.example.tweet.screens.CategoriesView
import com.example.tweet.ui.theme.TweetTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TweetTheme {
                App()
            }
        }
    }
}


@Composable
fun App() {
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable(route = "main") {
            ListViewCompose(
                onclick = {
                    navController.navigate("detail/${Uri.encode(it)}")
                }
            )
        }
        composable(route = "detail/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            )
        ) {
            TweetViewCompose()
        }
    }
}

@Composable
fun ListViewCompose(onclick: (category: String) -> Unit) {
    CategoriesView(onclick)
}

@Composable
fun TweetViewCompose() {
    CateggoryDetailsView()
}

