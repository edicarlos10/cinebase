package com.example.cinebase.features.home.base

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.cinebase.features.home.enuns.NavScreens

@Composable
fun BottomNavigation(
    navigationBarItems: List<NavScreens>,
    onItemClick: (NavScreens) -> Unit,
    isSelected: (NavScreens) -> Boolean,
) {
    NavigationBar{
        navigationBarItems.forEach { item ->
            NavigationBarItem(
                selected = isSelected(item),
                label = {
                    Text(text = item.title, style = MaterialTheme.typography.labelMedium)
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = null)
                },
                onClick = {
                    onItemClick(item)
                }
            )
        }
    }
}