package com.example.cinebase.features.home.nowplaying

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cinebase.R
import com.example.cinebase.features.home.Constants
import com.example.domain.cinebase.home.model.NowPlaying

@Composable
fun NowPlaying(response: NowPlaying) {
    Card(
        modifier = Modifier.padding(16.dp)

    ) {
        LazyColumn{
            items(response.results!!) { item ->
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(Constants.imageUrlBase + item?.poster_path)
                        .crossfade(true).build(),
                    error = painterResource(R.drawable.ic_broken_image),
                    placeholder = painterResource(R.drawable.loading_animation),
                    contentDescription = "imagem do filme",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NowPlayingPreview() {
    NowPlayingPreview()
}