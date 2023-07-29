package com.example.cinebase.features.home.base

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cinebase.features.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopBar(homeViewModel: HomeViewModel?) {
    var active by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    val items = remember {
        mutableStateListOf("")
    }
    val paddingHorizontal: Dp by animateDpAsState(
        if (active) {
            0.dp
        } else {
            16.dp
        }, label = ""
    )

    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = paddingHorizontal)
            .graphicsLayer { scaleX = 1f },
        query = searchText,
        onQueryChange = { searchText = it },
        onSearch = {
            if (searchText !in items) {
                items.add(searchText)
            }
            active = false
            homeViewModel?.getMovieSearch(query = searchText)
        },
        active = active,
        onActiveChange = {
            active = it
        },
        placeholder = { Text(text = "Busca") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "")
        },
        trailingIcon = {
            if (active) {
                Icon(
                    modifier = Modifier.clickable {
                        if (searchText.isNotEmpty()) {
                            searchText = ""
                        } else {
                            active = false
                        }
                    },
                    imageVector = Icons.Default.Close,
                    contentDescription = ""
                )
            }
        }
    ) {
        items.forEach {
            if (it.isNotBlank()) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clickable {
                            searchText = it
                        }
                ) {
                    Icon(
                        imageVector = Icons.Default.History,
                        contentDescription = "",
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    Text(text = it)
                }
            }
        }
    }
}