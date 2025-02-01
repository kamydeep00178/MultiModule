package com.lock.home.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lock.domain.common.Resource
import com.lock.domain.models.Post
import com.lock.ui.loader.CircularLoader

@Composable
fun Home(viewModel: HomeViewModel = hiltViewModel(), modifier: Modifier = Modifier) {

    val postData by viewModel.postList.collectAsState()

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
                post = (postData as Resource.Success<List<Post>>).data
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
    post: List<Post>? = null
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppBarWithCenterText()
        LazyColumn {
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarWithCenterText() {
    TopAppBar(
        title =
        {
            Column {
                Text(
                    text = "Your Location",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Text(
                    text = "Mohali, Punjab",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { /* Handle back button click */ }) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }
        },
        actions = {
            IconButton(onClick = { /* Handle more options click */ }) {
                Icon(Icons.Filled.ShoppingCart, contentDescription = "Cart")
            }
        },
        modifier = Modifier.fillMaxWidth(),
        windowInsets = WindowInsets(top = 1.dp)
    )
}