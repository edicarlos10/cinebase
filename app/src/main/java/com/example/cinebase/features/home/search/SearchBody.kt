package com.example.cinebase.features.home.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cinebase.features.home.HomeViewModel
import com.example.cinebase.features.home.base.DefaultError
import com.example.cinebase.features.home.base.Loading
import com.example.domain.cinebase.base.State

@Composable
fun SearchBody(homeViewModel: HomeViewModel?, paddingValues: PaddingValues){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {
        homeViewModel?.search?.collectAsStateWithLifecycle()?.value.let { response ->
            when (response) {
                is State.Error -> {
                    DefaultError(refresh = {homeViewModel?.getNowPlaying()})
                }

                is State.Data -> {
                    Search(response = response.data, Modifier.padding(16.dp), onClick = {
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