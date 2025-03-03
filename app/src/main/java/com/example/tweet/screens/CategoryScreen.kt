package com.example.tweet.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tweet.R
import com.example.tweet.viewmodels.CategoryViewModel

@Composable
fun CategoriesView(onclick: (category:String)->Unit) {
    val categoryModel: CategoryViewModel = hiltViewModel()
    val category: State<List<String>> = categoryModel.categorystate.collectAsState()
    LazyVerticalGrid(
        verticalArrangement = Arrangement.SpaceAround,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp),
        userScrollEnabled = true

    ) {
        items(category.value.distinct() ) {
            CategoryItemView(category = it, onclick)
        }
    }
}


@Composable
fun CategoryItemView(category:String,onclick: (category: String) -> Unit) {
    val painsrc = painterResource(R.drawable.waves_bg)
    Box(Modifier.padding(10.dp,20.dp).clickable { onclick(category) }.
    size(160.dp).clip(RoundedCornerShape(8.dp)).border(1.dp, Color(0XFFEEEEEE)).paint(painter = painsrc, contentScale = ContentScale.Crop),
        contentAlignment = Alignment.BottomCenter) {
        Text(text = category,
            fontSize = 18.sp,
            fontWeight = FontWeight.W100,
            modifier = Modifier.padding(20.dp),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center)
    }
}