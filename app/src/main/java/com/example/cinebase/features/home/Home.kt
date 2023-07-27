package com.example.cinebase.features.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.cinebase.features.home.base.BottomNavigation
import com.example.cinebase.features.home.base.SearchTopBar
import com.example.cinebase.features.home.enuns.NavScreens.Home
import com.example.cinebase.features.home.enuns.NavScreens.values
import com.example.cinebase.features.home.nowplaying.NowPlayingBody
import com.example.cinebase.ui.theme.CinebaseTheme

@Composable
fun Home(homeViewModel: HomeViewModel?) {
    val navigationItems = values().toList()
    var currentScreen by rememberSaveable { mutableStateOf(navigationItems.first()) }


    LaunchedEffect(Unit) {
        homeViewModel?.getNowPlaying()
    }
    Scaffold(
        topBar = {
            SearchTopBar()
        },
        bottomBar = {
            BottomNavigation(navigationBarItems = navigationItems,
                onItemClick = { screen ->
                    currentScreen = screen
                    if (currentScreen.compareTo(Home) == 0) {
                        homeViewModel?.getNowPlaying()
                    }
                },
                isSelected = { screen ->
                    currentScreen == screen
                })
        }
    ) { paddingValues ->
        NowPlayingBody(homeViewModel = homeViewModel, paddingValues = paddingValues)
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    CinebaseTheme {
        Home(null)
    }
}