package com.example.cinebase.features.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cinebase.R
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
                        AsyncImage(
                            model = ImageRequest.Builder(context = LocalContext.current)
                                .data(Constants.imageUrlBase + response.data.results?.get(0)?.poster_path)
                                .crossfade(true).build(),
                            error = painterResource(R.drawable.ic_broken_image),
                            placeholder = painterResource(R.drawable.loading_animation),
                            contentDescription = "imagem do clima",
                            contentScale = ContentScale.FillBounds
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