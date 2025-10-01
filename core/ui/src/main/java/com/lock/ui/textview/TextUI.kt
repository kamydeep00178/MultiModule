package com.lock.ui.textview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextSubHeader(text: String,modifier: Modifier = Modifier, color: Color = Color.Unspecified) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        color = color,
        modifier = modifier
    )
}

@Composable
fun TextSubHeader1(text: String,modifier: Modifier = Modifier, color: Color = Color.Unspecified) {
    Text(
        text = text,
        fontSize = 14.sp,
        color = color,
        modifier = modifier
    )
}

/*
@Composable
fun ButtonLikeText(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    cornerRadius: Int = 8,
    padding: Int = 16
) {
    Surface(
        modifier = modifier
            .clickable(
                onClick = onClick,
                indication = rememberRipple(),
                interactionSource = remember { MutableInteractionSource() }
            ),
        shape = RoundedCornerShape(cornerRadius.dp),
        color = backgroundColor,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline) // Optional border
    ) {
        Box(
            modifier = Modifier.padding(horizontal = padding.dp, vertical = padding.dp / 2)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                color = textColor
            )
        }
    }
}*/
