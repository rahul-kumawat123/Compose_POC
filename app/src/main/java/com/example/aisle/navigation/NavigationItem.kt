package com.example.aisle.navigation

const val TITLE = "title"
const val ORIENTATION ="orientation"
sealed class Screen(val route:String){
    object SplashScreen : Screen("splash_screen")
    object BottomNavScreen : Screen("Bottom_navigation_screen")
    object LoginScreen : Screen("login")
    object Welcome: Screen("welcome_screen")
    object SignUp: Screen("signup_screen")
    object PasswordScreen: Screen("password_screen")
    object OtpScreen: Screen("otp_screen")
    object SignUpDetailScreen: Screen("signUpDetail")
    object RetryScreen: Screen("retryScreen")
    object SuccessScreen: Screen("successScreen")
    object ForgotPassword: Screen("forgotPassword")
    object CreateNewPassword: Screen("createNewPass")
    object DetailScreen: Screen("detail_screen")
    object VideoPlayer: Screen("videoPlayerScreen")
    object LiveScreen: Screen("liveScreen")
    object SeeAllScreen : Screen("seeAll_screen/{$TITLE}/{$ORIENTATION}"){
        fun passArgs(title:String,orientation:String):String {
            return "seeAll_screen/$title/$orientation"
        }
    }
    object ShowErrorScreen : Screen("showError_screen")
    object InternetIssueScreen: Screen("internetError_screen")
    object PlayerScreen : Screen("player_screen")

    object StartScreen : Screen("start_screen")

    object MenuScreen : Screen("menu_screen")

    object SearchScreen: Screen("search_screen")
}
