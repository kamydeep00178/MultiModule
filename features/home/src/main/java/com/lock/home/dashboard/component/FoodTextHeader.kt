package com.lock.home.dashboard.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.lock.home.R
import com.lock.ui.textview.TextSubHeader
import com.lock.ui.textview.TextSubHeader1

@Composable
fun FoodTextHeaderWithSecondaryAction(mainText: String, secondaryText: String, modifier: Modifier = Modifier,secondaryClick : () -> Unit = {}) {
    Row(modifier = modifier.fillMaxWidth()){
        TextSubHeader(
            text = mainText,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f),
        )

        TextSubHeader1(
            text = secondaryText,
            color = colorResource(R.color.orange_700).copy(alpha = 0.8f),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clickable(onClick = secondaryClick)
        )
    }
}