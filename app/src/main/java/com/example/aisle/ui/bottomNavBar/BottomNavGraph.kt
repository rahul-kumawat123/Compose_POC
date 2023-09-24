package com.example.aisle.ui.bottomNavBar

import android.app.Activity
import android.os.Build
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.aisle.presentation.Home
import com.example.aisle.presentation.Kids
import com.example.aisle.presentation.LiveTv
import com.example.aisle.presentation.Movie

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun BottomNavGraph(navController: NavHostController) {
    val activity = LocalContext.current as Activity
//    val sharedViewModel: SharedViewModel = viewModel()
//    val viewModel: HomeListViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.screenRoute,
    ) {

        composable(BottomNavItem.Home.screenRoute) {
            LaunchedEffect(key1 = activity) {
                activity.window.setBackgroundDrawable(null)
            }
            Home(navController)
        }
        composable(BottomNavItem.Movie.screenRoute) {
            LaunchedEffect(key1 = activity) {
                activity.window.setBackgroundDrawable(null)
            }
            Movie(navController)
        }
        composable(BottomNavItem.Kids.screenRoute) {
            LaunchedEffect(key1 = activity) {
                activity.window.setBackgroundDrawable(null)
            }
            Kids(navController)
        }
        composable(BottomNavItem.LiveTv.screenRoute) {
            LaunchedEffect(key1 = activity) {
                activity.window.setBackgroundDrawable(null)
            }
            LiveTv(navController)
        }
    }
}