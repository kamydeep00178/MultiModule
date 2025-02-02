package com.lock.home.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lock.domain.common.Resource
import com.lock.domain.models.Post
import com.lock.ui.loader.CircularLoader

@Composable
fun Home(viewModel: HomeViewModel = hiltViewModel(), modifier: Modifier = Modifier) {

    val postData by viewModel.postList.collectAsState()

    val categoryList = viewModel.getCategories()

    val selectedCategory by viewModel.selectedCategory.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getPosts()
    }

    when (postData) {
        is Resource.Loading -> {
            CircularLoader()
        }

        is Resource.Success -> {
            HomeScreen(
                modifier = modifier,
                post = (postData as Resource.Success<List<Post>>).data,
                categoryList = categoryList,
                selectedCategory = selectedCategory,
                onCategorySelected = {
                    viewModel.selectedCategory(it)
                }
            )
        }

        is Resource.Error -> {
            Text(text = (postData as Resource.Error).message.toString(), fontSize = 20.sp)
        }
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier,
    post: List<Post>? = null,
    categoryList : List<String>? = null,
    selectedCategory: String? = null,
    onCategorySelected : (String) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppBarWithCenterText()
        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            item{
                HorizontalViewPagerWithAnimationAndImages()
            }
            item{
                CategoryChip(
                    categoriesList =   categoryList,
                    selectedCategory = selectedCategory,
                    onCategorySelected = onCategorySelected
                )
            }
            items(post!!) { post ->
                PostContent(post = post, modifier = modifier)
            }
        }
    }
}

@Composable
fun PostContent(post: Post, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = post.title.toString(),
            modifier = Modifier.align(Alignment.Start),
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = post.body.toString(),
            modifier = Modifier.align(Alignment.Start),
            fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
            color = Color.Blue
        )
    }
}


