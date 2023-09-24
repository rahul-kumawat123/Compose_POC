package com.example.aisle.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.aisle.R
import com.example.aisle.ui.bottomNavBar.BottomNavGraph
import com.example.aisle.ui.bottomNavBar.BottomScreenNavigation
import com.example.aisle.ui.theme.GilroyRegular


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavScreen(){
    val navBottomController = rememberNavController()
//    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val bottomBarState = rememberSaveable { (mutableStateOf(false)) }
//    val menuList = viewModel.myMenuList?.collectAsState()

    // get data
    val navBackStackEntry by navBottomController.currentBackStackEntryAsState()
    when (navBackStackEntry?.destination?.route) {
        "home" -> {
            // Show BottomBar
            bottomBarState.value = true
        }

        "movie" -> {
            // Show BottomBar
            bottomBarState.value = true
        }

        "kids" -> {
            // Show BottomBar
            bottomBarState.value = true
        }

        "live_tv" -> {
            // Show BottomBar
            bottomBarState.value = true
        }

        "menu" -> {
            // Show BottomBar
            bottomBarState.value = false
        }

        "seeAll_screen" -> {
            bottomBarState.value = false
        }

        else -> {
            bottomBarState.value = false
        }

    }
        Scaffold(modifier = Modifier.background(Color.White),
            bottomBar = {
                BottomScreenNavigation(navController = navBottomController, bottomBarState)
            }) {
            BottomNavGraph(navController = navBottomController)
        }

    }

@Composable
fun Home(navHostController: NavHostController) {
   Box(modifier = Modifier
       .fillMaxSize()
       .background(Color.White)) {
      Text(text = "Under Development", color = Color.Black)
   }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun Movie(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(top = 10.dp),
            verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally) {
            TopSection()
            UpgradetoPremium()
        }
    }
}

@Composable
fun Kids(navHostController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Text(text = "Under Development", color = Color.Black)
    }
}

@Composable
fun LiveTv(navHostController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Text(text = "Under Development", color = Color.Black)
    }
}

@Composable
fun TopSection() {
    Column(modifier = Modifier.padding(10.dp)){
        Text(
            text = "Notes",
            style = TextStyle(
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = GilroyRegular,
                color = Color.Black
            ),
            modifier = Modifier.align(CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Personal messages to you",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = GilroyRegular,
                color = Color.Black
            ),
            modifier = Modifier.align(CenterHorizontally)
        )

        Image(
            painter = painterResource(id = R.drawable.meena), contentDescription = "",
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
        )
    }
}

@Composable
fun UpgradetoPremium() {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Interested In You",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = GilroyRegular,
                color = Color.Black
            ),
            modifier = Modifier.align(Alignment.Start)
        )

        Row(modifier = Modifier.align(Alignment.Start)) {
            Text(
                text = "Premium members can \n view all their likes at once",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = GilroyRegular,
                    color = Color.Black
                ),
                maxLines = 2
            )

            Box(modifier = Modifier
                .clickable {
                }) {
                Image(
                    painter = painterResource(id = R.drawable.upgrade_button),
                    contentDescription = "",
                    modifier = Modifier
                        .width(113.dp)
                        .height(50.dp)
                )
                Text(
                    text = "Upgrade",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(
                        start = 17.dp, end = 18.dp, top = 11.dp,
                        bottom = 12.dp
                    )
                )
            }
        }
        Column(modifier = Modifier.height(255.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Start)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.teena), contentDescription = "",
                    modifier = Modifier
                        .width(168.dp)
                        .height(255.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Image(
                    painter = painterResource(id = R.drawable.beena), contentDescription = "",
                    modifier = Modifier
                        .width(168.dp)
                        .height(255.dp)
                )
            }
        }
    }
}



