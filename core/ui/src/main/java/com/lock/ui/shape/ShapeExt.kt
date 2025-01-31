package com.lock.ui.shape

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color

fun Modifier.drawCircleBehind(
    color: Color
) = drawBehind {
    drawCircle(color = color)
}