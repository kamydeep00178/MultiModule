package com.lock.home.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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