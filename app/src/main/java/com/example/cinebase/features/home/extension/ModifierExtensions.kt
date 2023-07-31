package com.example.cinebase.features.home.extension

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer

/**
 * Example bruhs colors:
 * listOf(Color.Transparent, Color.Black)
 * OR
 * Brush.horizontalGradient(
 *     0f to Color.Transparent,
 *     0.1f to Color.Red,
 *     0.9f to Color.Red,
 *     1f to Color.Transparent
 * )
 */
fun Modifier.fadingEdge(brush: Brush) = this
    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen, alpha = 1f)
    .drawWithContent {
        drawContent()
        drawRect(
            brush = brush,
            blendMode = BlendMode.DstIn
        )
    }