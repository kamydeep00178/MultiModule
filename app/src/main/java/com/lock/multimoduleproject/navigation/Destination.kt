package com.lock.multimoduleproject.navigation

import com.lock.multimoduleproject.R

sealed class Destination(val route : String, val icon : Int,val title: String) {

    data object Home : Destination(route = "home", icon = R.drawable.bottom_home, title = "Home")

    data object Cart : Destination(route = "cart", icon = R.drawable.bottom_cart, title = "Cart")

    data object Search : Destination(route = "search", icon = R.drawable.bottom_search, title = "Search")

    data object Favourite : Destination(route = "favourite", icon = R.drawable.bottom_favourite, title = "Favourite")

    data object Profile : Destination(route = "profile", icon = R.drawable.bottom_profile, title = "Profile")

    companion object {
        val toList = listOf(Home, Cart, Search, Favourite, Profile)
    }
}