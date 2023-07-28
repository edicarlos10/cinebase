package com.example.cinebase.navigation

sealed class Screens (val route: String, val argumentKey: String){

    object Splash : Screens(
        route = "splash",
        argumentKey = "slash_key"
    )

    object Home : Screens(
        route = "home",
        argumentKey = "home_key"
    )
}