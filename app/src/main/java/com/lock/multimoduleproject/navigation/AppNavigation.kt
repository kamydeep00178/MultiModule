package com.lock.multimoduleproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lock.multimoduleproject.ui.theme.cart.Cart
import com.lock.multimoduleproject.ui.theme.favourite.Favourite
import com.lock.home.dashboard.Home
import com.lock.multimoduleproject.ui.theme.profile.Profile
import com.lock.multimoduleproject.ui.theme.search.Search

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destination.Home.route) {
        composable(Destination.Home.route) {
            Home()
        }
        composable(Destination.Cart.route) {
            Cart()
        }
        composable(Destination.Search.route) {
            Search()
        }
        composable(Destination.Favourite.route) {
            Favourite()
        }
        composable(Destination.Profile.route) {
            Profile()
        }
    }
}