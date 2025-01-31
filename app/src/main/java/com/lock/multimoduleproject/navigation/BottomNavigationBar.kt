package com.lock.multimoduleproject.navigation

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.lock.multimoduleproject.R

@Composable
fun BottomNavigationBar(navController: NavController,appItems : List<Destination>){

    NavigationBar(containerColor = colorResource(R.color.white)) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        appItems.forEach { item ->
            val isSelected = currentRoute == item.route
            val colorShape : Color = if (isSelected) colorResource(id = R.color.orange_700) else Color.Transparent
            NavigationBarItem(
                icon = {
                    Icon(painter = painterResource(id = item.icon), contentDescription = item.title)
                },
                label = {
                    item.title
                },
                selected = currentRoute == item.route,
                colors = NavigationBarItemColors(
                    selectedIconColor = colorResource(id = R.color.white),
                    unselectedIconColor = colorResource(id = R.color.black),
                    selectedTextColor = colorResource(id = R.color.orange_700),
                    unselectedTextColor = colorResource(id = R.color.black),
                    selectedIndicatorColor = colorResource(id = R.color.orange_700),
                    disabledIconColor = colorResource(id = R.color.black),
                    disabledTextColor = colorResource(id = R.color.black)
                ),
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }

    }

}