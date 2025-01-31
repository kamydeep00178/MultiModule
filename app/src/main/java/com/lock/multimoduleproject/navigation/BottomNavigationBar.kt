package com.lock.multimoduleproject.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.lock.multimoduleproject.R

@Composable
fun BottomNavigationBar(
    navController: NavController,
    appItems: List<Destination>,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
    ) {
        appItems.forEach { item ->
            val isSelected = currentRoute == item.route
            val interactionSource = remember { MutableInteractionSource() }
            val colorShape: Color =
                if (isSelected) colorResource(id = R.color.orange_700) else Color.Transparent
            NavigationBarItem(
                icon = {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(colorShape)
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title,
                        )
                    }
                },
                label = {
                    item.title
                },
                alwaysShowLabel = false,
                selected = currentRoute == item.route,
                colors = NavigationBarItemColors(
                    selectedIconColor = colorResource(id = R.color.white),
                    unselectedIconColor = colorResource(id = R.color.black),
                    selectedTextColor = colorResource(id = R.color.orange_700),
                    unselectedTextColor = colorResource(id = R.color.black),
                    selectedIndicatorColor = Color.Transparent,
                    disabledIconColor = colorResource(id = R.color.black),
                    disabledTextColor = colorResource(id = R.color.black)
                ),
                interactionSource = interactionSource,
                modifier = Modifier.clip(CircleShape),
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
                },
            )
        }

    }

}
