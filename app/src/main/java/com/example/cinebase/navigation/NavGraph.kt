package com.example.cinebase.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cinebase.SplashScreen
import com.example.cinebase.features.home.Home
import com.example.cinebase.features.home.HomeViewModel

@Composable
fun SetupNavGraph(navController: NavHostController, homeViewModel: HomeViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screens.Home.route) {
            Home(homeViewModel = homeViewModel)
        }
    }
}