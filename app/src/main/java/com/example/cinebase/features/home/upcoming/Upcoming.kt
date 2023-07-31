package com.example.cinebase.features.home.upcoming

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cinebase.R
import com.example.cinebase.features.home.Constants
import com.example.cinebase.features.home.extension.fadingEdge
import com.example.domain.cinebase.home.model.Upcoming

@Composable
fun Upcoming(response: Upcoming, modifier: Modifier, onClick: () -> Unit = {}) {
    Row {
        Text(
            "Em Breve",
            modifier = Modifier.padding(start = 16.dp, top = 8.dp),
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Light
            )
        )
    }

    LazyRow(
        modifier = Modifier
            .padding(top = 48.dp)
            .graphicsLayer {
                alpha = 1f
                compositingStrategy = CompositingStrategy.Offscreen
            }
            .fadingEdge(
                brush = Brush.horizontalGradient(
                    0.8f to Color.White,
                    1f to Color.Transparent
                )
            )
    ) {
        response.results?.let { listResult ->
            items(listResult) { item ->
                Card(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clickable {
                            onClick()
                        }
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(Constants.imageUrlBase + item?.poster_path)
                            .crossfade(true).build(),
                        error = painterResource(R.drawable.ic_broken_image),
                        placeholder = painterResource(R.drawable.loading_animation),
                        contentDescription = "imagem do filme",
                        contentScale = ContentScale.FillBounds
                    )
                }


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UpcomingPreview() {
    UpcomingPreview()
}