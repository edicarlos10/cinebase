package com.example.cinebase.features.home.enuns

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavScreens(
    val title: String,
    val icon: ImageVector,
) {
    Home(title = "Home", icon = Icons.Rounded.Home),
    Favorites(title = "Favoritos", icon = Icons.Rounded.Star),
    LastSeen(title = "Ultimos vistos", icon = Icons.Rounded.ThumbUp);
}