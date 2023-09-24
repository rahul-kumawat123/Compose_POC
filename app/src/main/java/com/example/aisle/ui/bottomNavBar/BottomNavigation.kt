package com.example.aisle.ui.bottomNavBar

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.rememberAsyncImagePainter
import com.example.aisle.ui.theme.botomNavSelectColor
import com.example.aisle.ui.theme.bottomBarColor
import com.example.aisle.ui.theme.bottomBarContentColor

@Composable
fun BottomScreenNavigation(navController: NavController, bottomState: MutableState<Boolean>) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Movie,
        BottomNavItem.Kids,
        BottomNavItem.LiveTv,
    )

    BottomNavigation(
            backgroundColor = bottomBarColor,
            contentColor = bottomBarContentColor,
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(25.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp,
                        color = bottomBarContentColor
                    )
                },
                selectedContentColor = botomNavSelectColor,
                unselectedContentColor = Color.White,
                alwaysShowLabel = true,
                selected = currentRoute == item.screenRoute,
                onClick = {
                    navController.navigate(item.screenRoute) {
                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
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