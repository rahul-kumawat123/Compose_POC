package com.example.aisle.navigation


import android.app.Activity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aisle.presentation.BottomNavScreen
import com.example.aisle.presentation.OtpScreen
import com.example.aisle.presentation.PhoneLoginScreen
import com.example.aisle.presentation.SplashScreen

@ExperimentalAnimationApi
@Composable
fun Navigation(navController: NavHostController, startDestination: String) {
    val activity = LocalContext.current as Activity
//    val sharedViewModel: SharedViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(Screen.SplashScreen.route) {
            SplashScreen(navHostController = navController)
        }

        composable(Screen.BottomNavScreen.route) {
            BottomNavScreen()
        }

        composable(Screen.LoginScreen.route) {
            PhoneLoginScreen(navController)
        }


        composable(Screen.OtpScreen.route) {
            OtpScreen(navController)
        }

    }
}