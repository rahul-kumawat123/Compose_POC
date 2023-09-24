package com.example.aisle.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.aisle.R
import com.example.aisle.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navHostController: NavHostController
) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        navHostController.navigate(Screen.LoginScreen.route)
    }

    Splash()
}
@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.aisle),
            contentDescription = "Splash screen logo",
        )
    }

}