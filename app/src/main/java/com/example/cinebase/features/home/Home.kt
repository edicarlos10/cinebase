package com.example.cinebase.features.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cinebase.features.home.base.BottomNavigation
import com.example.cinebase.features.home.base.DefaultError
import com.example.cinebase.features.home.base.Loading
import com.example.cinebase.features.home.base.SearchTopBar
import com.example.cinebase.features.home.base.TopBar
import com.example.cinebase.features.home.base.TopBarIcon
import com.example.cinebase.features.home.enuns.NavScreens.Home
import com.example.cinebase.features.home.enuns.NavScreens.values
import com.example.cinebase.features.home.nowplaying.NowPlaying
import com.example.cinebase.ui.theme.CinebaseTheme
import com.example.domain.cinebase.base.State

@Composable
fun Home(homeViewModel: HomeViewModel?) {
    var isSearching by remember { mutableStateOf(false) }
    val navigationItems = values().toList()
    var currentScreen by rememberSaveable { mutableStateOf(navigationItems.first()) }
    var searchText by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        homeViewModel?.getNowPlaying()
    }
    Scaffold(
        topBar = {
            if (isSearching) {
                SearchTopBar(
                    searchText = searchText,
                    placeholderText = "Titulo do filme",
                    onClearClick = { searchText = "" },
                    onBackPressed = { isSearching = false },
                    onSearchTextChanged = {
                        searchText = it
                    }
                )
            } else {
                TopBar(
                    title = "Filmes",
                    actions = {
                        TopBarIcon(
                            onClick = { isSearching = true },
                            imageVector = Icons.Default.Search
                        )
                    }
                )
            }
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ) {
            homeViewModel?.nowPlaying?.collectAsStateWithLifecycle()?.value.let { response ->
                when (response) {
                    is State.Error -> {
                        DefaultError(refresh = {homeViewModel?.getNowPlaying()})
                    }

                    is State.Data -> {
                        NowPlaying(response = response.data, Modifier.padding(16.dp), onClick = {
                            //TODO: open detail
                        })
                    }

                    is State.Loading -> {
                        Loading()
                    }

                    else -> {}
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    CinebaseTheme {
        Home(null)
    }
}