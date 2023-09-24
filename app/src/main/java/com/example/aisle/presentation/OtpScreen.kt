package com.example.aisle.presentation

import android.os.CountDownTimer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
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

@Composable
fun OtpScreen(
    navController: NavHostController,
//    sharedViewModel: SharedViewModel,
     viewModel: OtpViewModel = hiltViewModel(),
//    loginViewModel: LoginViewModel = hiltViewModel(),
//    forgotViewModel: ForgotPasswordViewModel = hiltViewModel()

) {
    val otp = remember { mutableStateOf(TextFieldValue()) }

    var setView: String by remember {
        mutableStateOf("30")
    }

    var nums: Long by remember {
        mutableStateOf(10L)
    }


    val cuntNum = object : CountDownTimer(30000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            nums = millisUntilFinished / 1000
            setView = "$nums"

        }

        override fun onFinish() {
            setView = "00"
        }
    }
    if (setView == "30") {

        cuntNum.start()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
    }

    Column(Modifier.padding(20.dp)) {
        Row(
            Modifier.height(60.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "+919599236895", style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )

            Spacer(modifier = Modifier.width(10.dp))

            Image(
                painterResource(R.drawable.vector),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        navController.popBackStack()
                    }

            )
        }

        Text(
            text = "Enter The \n OTP",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(20.dp))


        Row {
            Column(
                Modifier.weight(1f)
            ) {
                EntryTextFields(
                    textFieldValue = otp,
                    visualTransformation = VisualTransformation.None,
                    size = 36.dp,
                    width = 78.dp
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.align(Alignment.Start)) {
            Box(modifier = Modifier.clickable {
                viewModel.callOtpApi("+919876543212","1234")
                navController.navigate(Screen.BottomNavScreen.route)
            }) {
                Image(
                    painter = painterResource(id = R.drawable.rec),
                    contentDescription = "",
                    modifier = Modifier.size(width = 96.dp, height = 40.dp)
                )

                Text(
                    text = "Continue",
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
            Spacer(modifier = Modifier.width(12.dp))
            Box(modifier = Modifier.padding(top = 10.dp)) {
                CheckSetView(setView)
            }
        }
    }
}

@Composable
fun CheckSetView(setView: String) {
    if (setView != "00") {
        Text(
            text = "00:$setView",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black
            )
        )
    }
}

//    val userEmail = sharedViewModel.res.value
//
//    val checkScreen = sharedViewModel.boolean.value
//    val forgotPasswordScreen = sharedViewModel.otpBoolean.value
//    val oneTimeApiCall = remember { mutableStateOf(false) }
//    val  context = LocalContext.current
//
//    if (oneTimeApiCall.value) {
//
//        val validOtpResponse = viewModel.getValidateOtpResponse().observeAsState().value
//        if (validOtpResponse != null) {
//            ValidateOtpResponse(
//                validOtpResponse,
//                navController,
//                checkScreen,
//                oneTimeApiCall,
//                sharedViewModel,
//                userEmail,
//                forgotPasswordScreen,
//            )
//        }
//
//    }
//
//    var user = userEmail
//    val char = '*'
//    val index = 2
//    if (userEmail.isNotEmpty()) {
//        user = user.substring(0, index) + char +
//                user.substring(index + 1)
//
//        user = user.substring(0, 1) + "*" +
//                user.substring(1 + 1)
//        user = user.substring(0, 3) + "*" +
//                user.substring(3 + 1)
//
//
//    }
//
//
//    var nums: Long by remember {
//        mutableStateOf(10)
//    }
//    var setView: String by remember {
//        mutableStateOf("30")
//    }
//
//    val cuntNum = object : CountDownTimer(30000, 1000) {
//        override fun onTick(millisUntilFinished: Long) {
//            nums = millisUntilFinished / 1000
//            setView = "$nums"
//
//        }
//
//        override fun onFinish() {
//            setView = "00"
//        }
//    }
//    if (setView == "30") {
//
//        cuntNum.start()
//    }
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(backgroundColor)
//    ) {
//    }
//
//    Column(Modifier.padding(20.dp)) {
//        Row(
//            Modifier.height(60.dp),
//            horizontalArrangement = Arrangement.Start
//        ) {
//        }
//    }
//    var otpValue by remember {
//        mutableStateOf("")
//    }
//
//    Column(
//
//        modifier = androidx.compose.ui.Modifier
//            .padding(otpStartEndPadding.dp)
//    )
//    {
//        Row {
//
//            Spacer(modifier = Modifier.height(10.dp))
//
//            Image(
//                painterResource(R.drawable.arrow_back_24),
//                contentDescription = "",
//                contentScale = ContentScale.Fit,
//                modifier = Modifier
//                    .size(20.dp)
//                    .clickable {
//                        navController.popBackStack()
//                    }
//
//            )
//        }
//
//        Spacer(modifier = Modifier.height(25.dp))
//
//        Text(
//            text = enterOtp,
//            style = TextStyle(
//                fontSize = 18.sp,
//                fontFamily = robotoMedium,
//                color = whiteColor
//            )
//        )
//        Spacer(modifier = Modifier.height(5.dp))
//        Row {
//            Text(
//                text = weHaveSentAnOtpTo,
//                style = TextStyle(
//                    fontSize = 14.sp,
//                    fontFamily = robotoMedium,
//                    color = inputLabelColor
//                )
//            )
//            Text(
//                text = user,
//                style = TextStyle(
//                    fontSize = 14.sp,
//                    fontFamily = robotoMedium,
//                    color = whiteColor
//                )
//            )
//        }
//
//        Text(
//            text = pleaseVerifyOtpToChangeThePassword,
//            style = TextStyle(
//                fontSize = 14.sp,
//                fontFamily = robotoMedium,
//                color = inputLabelColor
//            )
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
//            OtpTextField(
//                otpText = otpValue,
//                onOtpTextChange = { value, _ ->
//                    otpValue = value
//                }
//            )
//        }
//        Spacer(modifier = Modifier.height(5.dp))
//
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Row {
//                CheckSetView(setView)
//            }
//            Row(
//                Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.End
//            ) {
//                Text(
//                    text = didNotGetOtp,
//                    style = TextStyle(
//                        fontSize = 13.sp,
//                        color = whiteColor,
//                        textAlign = TextAlign.End
//                    )
//                )
//                Text(
//                    text = resend,
//
//                    Modifier.clickable {
//                        val isExist = userEmail.contains('@')
//                        viewModel.startTimer(setView, cuntNum)
//                        viewModel.checkOtpScreen(isExist, checkScreen, loginViewModel, forgotPasswordScreen, forgotViewModel, userEmail,context)
//                    },
//
//
//                    style = TextStyle(
//                        fontSize = 13.sp,
//                        fontFamily = robotoBold,
//                        color = checkResendColor(setView),
//
//                        textAlign = TextAlign.End
//
//
//                    )
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(20.dp))
//        Row(Modifier.fillMaxWidth()) {
//
//            val color = checkColor(otpValue)
//
//            EntryButtons(
//                text = verify,
//
//                onClick = {
//                    viewModel.checkVerifyOnClick(otpValue, oneTimeApiCall, userEmail,context)
//                }, color
//            )
//        }
//    }
//
//}
//
//fun checkColor(otpValue: String): Color {
//    return if (otpValue.length == 6) skyBlueColor else buttonBorderColor
//}
//
//fun checkResendColor(setView: String): Color {
//    return if(setView == "00") skyBlueColor else whiteColor
//}
//
//@Composable
//fun CheckSetView(setView: String) {
//    if (setView != "00") {
//        Text(
//            text = "$otpExpireIn 00:$setView",
//            style = TextStyle(
//                fontSize = 14.sp,
//                fontFamily = robotoRegular,
//                color = whiteColor
//            )
//        )
//    }
//}
//
//
//@Composable
//fun ValidateOtpResponse(
//    validOtpResponse: Resource<ValidateOtpResponseModel>,
//    navController: NavHostController,
//    checkScreen: Boolean,
//    oneTimeApiCall: MutableState<Boolean>,
//    sharedViewModel: SharedViewModel,
//    userEmail: String,
//    checkForgetPassScreen: Boolean
//) {
//    val viewModel: OtpScreenViewModel = hiltViewModel()
//    val context = LocalContext.current
//
//    when (validOtpResponse.status) {
//        Resource.Status.SUCCESS -> {
//            oneTimeApiCall.value = false
//
//            if (checkScreen) {
//                sharedViewModel.setData(userEmail)
//                sharedViewModel.setBoolean(false)
//                sharedViewModel.setToken(validOtpResponse.data?.data?.jwtResponseToken.toString())
//
//                navController.navigate(Screen.SignUpDetailScreen.route)
//
//            } else if (checkForgetPassScreen) {
//                sharedViewModel.setData(userEmail)
//                sharedViewModel.setToken(validOtpResponse.data?.data?.jwtResponseToken.toString())
//
//                navController.navigate(Screen.CreateNewPassword.route)
//
//            } else {
//                val token = validOtpResponse.data?.data?.jwtResponseToken
//                viewModel.saveData(token!!)
//                navController.navigate(Screen.BottomNavigationScreen.route)
//
//                navController.popBackStack()
//
//            }
//
//            validOtpResponse.data?.message
//
//        }
//        Resource.Status.ERROR -> {
//            oneTimeApiCall.value = false
//
//            toast(context, error + validOtpResponse.message.toString())
//        }
//        Resource.Status.LOADING -> {
//            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                CircularProgressIndicator()
//            }
//        }
//
//        else -> {
//            Log.e(tag,noDataFound)
//        }
//    }
//}
