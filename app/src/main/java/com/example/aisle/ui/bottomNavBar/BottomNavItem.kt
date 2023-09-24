package com.example.aisle.ui.bottomNavBar

import com.example.aisle.R

sealed class BottomNavItem(var title: String, var icon: Int, var screenRoute: String){

    object Home : BottomNavItem("", R.drawable.discover, "discover")
    object Movie: BottomNavItem("", R.drawable.notes, "notes")
    object Kids: BottomNavItem("", R.drawable.matches, "matches")
    object LiveTv: BottomNavItem("", R.drawable.profile, "profile")
}