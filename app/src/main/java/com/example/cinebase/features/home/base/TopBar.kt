package com.example.cinebase.features.home.base

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String= "",
    onBackPressed: (() -> Unit)? = null,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    actions: @Composable RowScope.() -> Unit = {}
) {
    Surface(shadowElevation = 2.dp) {
        TopAppBar(
            title = { Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
            navigationIcon = {
                if (onBackPressed != null) {
                    TopBarIcon(onClick = { onBackPressed() }, imageVector = Icons.Default.ArrowBack)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = containerColor,
                actionIconContentColor = contentColorFor(containerColor),
                navigationIconContentColor = contentColorFor(containerColor),
                titleContentColor = contentColorFor(containerColor)
            ),
            actions = actions,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopBar() {
    TopBar()
}