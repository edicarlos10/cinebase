package com.example.cinebase.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinebase.features.home.base.BottomNavigation
import com.example.cinebase.features.home.base.SearchTopBar
import com.example.cinebase.features.home.enuns.NavScreens.Home
import com.example.cinebase.features.home.enuns.NavScreens.values
import com.example.cinebase.features.home.nowplaying.NowPlayingBody
import com.example.cinebase.features.home.search.SearchBody
import com.example.cinebase.features.home.upcoming.UpComingBody
import com.example.cinebase.ui.theme.CinebaseTheme

@Composable
fun Home(homeViewModel: HomeViewModel?) {
    val navigationItems = values().toList()
    var currentScreen by rememberSaveable { mutableStateOf(navigationItems.first()) }


    LaunchedEffect(Unit) {
        homeViewModel?.getNowPlaying()
        homeViewModel?.getUpcoming()
    }
    Scaffold(
        topBar = {
            SearchTopBar(homeViewModel)
        },
        bottomBar = {
            BottomNavigation(navigationBarItems = navigationItems,
                onItemClick = { screen ->
                    currentScreen = screen
                    if (currentScreen.compareTo(Home) == 0) {
                        homeViewModel?.getNowPlaying()
                        homeViewModel?.getUpcoming()
                    }
                },
                isSelected = { screen ->
                    currentScreen == screen
                })
        },
        content = { paddingValues ->
            Column(
            ) {
                NowPlayingBody(homeViewModel = homeViewModel, paddingValues = paddingValues)
            }
            Column (modifier = Modifier.padding(top = 280.dp)) {
                UpComingBody(homeViewModel = homeViewModel, paddingValues = paddingValues)
            }
            SearchBody(homeViewModel = homeViewModel, paddingValues = paddingValues)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    CinebaseTheme {
        Home(null)
    }
}