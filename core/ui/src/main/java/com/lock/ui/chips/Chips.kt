package com.lock.ui.chips

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun TextChipWithIcon(
    image: String = "https://picsum.photos/300/200?random=1",
    tintColor: Color,
    isSelected: Boolean,
    text: String,
    selectedColor: Color,
    modifier: Modifier = Modifier,
    onChecked: (Boolean) -> Unit,

    ) {

    val shape = CircleShape
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        modifier = modifier
            .padding(vertical = 2.dp, horizontal = 8.dp)
            .border(
                width = 0.dp,
                color = Color.White,
                shape = shape
            )
            .background(
                color = if (isSelected) selectedColor.copy(alpha = 0.8f) else Color.White,
                shape = shape
            )
            .clip(shape)
            .clickable {
                onChecked(!isSelected)
            }
            .padding(4.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = image
            ),
            contentDescription = "Page Image",
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            fontSize = 12.sp,
            text = text,
            color = if (isSelected) Color.White else Color.Black,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
    }

}

@Composable
@Preview(showBackground = true)
fun TextChipWithIconPreview() {
    val textChipRememberOneState = remember {
        mutableStateOf(false)
    }
    TextChipWithIcon(
        image = "https://picsum.photos/300/200?random=1",
        tintColor = Color.Black,
        isSelected = false,
        text = "Camera",
        onChecked = {textChipRememberOneState.value = it},
        selectedColor = Color.Black
    )

    val textChipRememberOneState1 = remember {
        mutableStateOf(false)
    }
    TextChipWithIcon(
        image = "https://picsum.photos/300/200?random=1",
        tintColor = Color.Black,
        isSelected = true,
        text = "Camera",
        onChecked = {textChipRememberOneState1.value = it},
        selectedColor = Color.Black
    )
}