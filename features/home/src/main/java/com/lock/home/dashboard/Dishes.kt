package com.lock.home.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.lock.home.dashboard.component.FoodTextHeaderWithSecondaryAction
import com.lock.ui.textview.TextSubHeader

@Composable
fun Dishes() {
    Column(modifier = Modifier.padding(top = 14.dp)) {
        FoodTextHeaderWithSecondaryAction(
            mainText = "Popular Dishes", secondaryText = "See all", secondaryClick = {}
        )
        DishItem()
    }
}

@Composable
fun DishItem() {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = rememberAsyncImagePainter(
                model = "https://picsum.photos/300/200?random=1"
            ),
            contentDescription = "Page Image",
            modifier = Modifier
                .width(80.dp)
                .height(120.dp)
                .clip(CircleShape)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.Crop
        )
        Card(
            modifier = Modifier
                .width(200.dp)
                .background(Color.White)
                .align(Alignment.BottomEnd),
            shape = RoundedCornerShape(
                topStart = 30.dp,
                topEnd = 30.dp,
                bottomStart = 4.dp,
                bottomEnd = 4.dp
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Column {
                    Text(text = "4.5", modifier = Modifier.align(Alignment.CenterHorizontally))
                    TextSubHeader(
                        "Chicken Wings",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    TextSubHeader(
                        "Chicken Wings are testy \n testy..",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}


