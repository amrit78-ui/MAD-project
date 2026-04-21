package com.dailyquotes.app.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedHeartButton(
    isLiked: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    
    // Scale animation to create popping effect
    val scale by animateFloatAsState(
        targetValue = if (isLiked) 1.2f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "heartScale"
    )

    // Color animation
    val tint by animateColorAsState(
        targetValue = if (isLiked) Color(0xFFFF5252) else Color.White,
        animationSpec = tween(durationMillis = 300),
        label = "heartTint"
    )

    // Using graphicsLayer to apply scale
    Icon(
        imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
        contentDescription = "Like Quote",
        tint = tint,
        modifier = modifier
            .size(48.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null, // Disable default ripple
                onClick = onClick
            )
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
    )
}
