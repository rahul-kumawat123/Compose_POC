package com.example.aisle.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.aisle.R
import com.example.aisle.navigation.Screen
import com.example.aisle.ui.Widget.EntryTextFields
import com.example.aisle.ui.theme.GilroyBold
import com.example.aisle.ui.theme.GilroyRegular

@Composable
fun PhoneLoginScreen(navHostController: NavHostController){

    val username = remember { mutableStateOf(TextFieldValue()) }
    val countryCode = remember { mutableStateOf(TextFieldValue()) }
    val loginViewModel: LoginViewModel = hiltViewModel()
    Box (
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White)
    ) {

    }
    Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Get OTP",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = GilroyRegular,
                    color = Color.Black
                )
            )
            Text(
                text = "Enter Your \n Phone Number",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = GilroyBold,
                    color = Color.Black
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))


        Row{
            Column(
                Modifier.weight(1f)
            ) {
                EntryTextFields(textFieldValue = countryCode,
                    visualTransformation = VisualTransformation.None,
                    size = 36.dp,
                    width = 64.dp)
            }
            Column(
                Modifier.weight(1f)
            ) {
                EntryTextFields(
                    textFieldValue = username,
                    visualTransformation = VisualTransformation.None,
                    36.dp,
                    147.dp)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier
            .align(Alignment.Start)
            .clickable {
                loginViewModel.callPhoneApi("+919876543212")
                navHostController.navigate(Screen.OtpScreen.route)
            }) {
           Image(painter = painterResource(id = R.drawable.rec),
               contentDescription = "",
               modifier = Modifier.size(width = 96.dp, height = 40.dp))

            Text(text = "Continue",
                style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black),
            modifier = Modifier.padding(start = 17.dp, end = 18.dp,top=11.dp,
            bottom = 12.dp))
        }
    }
}