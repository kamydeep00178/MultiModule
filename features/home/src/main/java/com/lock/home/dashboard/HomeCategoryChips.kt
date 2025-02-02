package com.lock.home.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lock.home.R
import com.lock.ui.chips.TextChipWithIcon

@Composable
fun CategoryChip(categoriesList: List<String>?,
                 modifier: Modifier = Modifier,
                 selectedCategory: String? = null,
                 onCategorySelected : (String) -> Unit = {}
) {
    Column(modifier.padding(vertical = 8.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Select by Category",
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            )
            Text(
                text = "See All",
                fontSize = 16.sp,
                color = colorResource(R.color.orange_700),
                modifier = Modifier.align(Alignment.CenterVertically),
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            )
        }
    }
    LazyRow {
        items(categoriesList!!) { category ->
            val textChipRememberOneState = remember {
                mutableStateOf(false)
            }
            TextChipWithIcon(
                image ="https://picsum.photos/300/200?random=2",
                tintColor = Color.Black,
                isSelected = (category == selectedCategory),
                text = category,
                onChecked = {
                    onCategorySelected(category)
                    textChipRememberOneState.value = it
                },
                selectedColor = colorResource(R.color.orange_700)
            )
        }
    }
}