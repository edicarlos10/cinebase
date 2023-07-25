package com.example.cinebase.features.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cinebase.ui.theme.CinebaseTheme
import com.example.domain.cinebase.base.State

@Composable
fun Home(homeViewModel: HomeViewModel?) {
    homeViewModel?.getNowPlaying()
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ) {
            homeViewModel?.nowPlaying?.collectAsStateWithLifecycle()?.value.let { response ->
                when (response) {
                    is State.Error -> {
                        DefaultError(message = response.cause?.message ?: "")
                    }

                    is State.Data -> {
                        Text(
                            text = response.data.results?.get(0)?.title ?: "",
                            style = MaterialTheme.typography.titleLarge
                        )
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