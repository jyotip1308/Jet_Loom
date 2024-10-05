package com.android.jetloom.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.jetloom.authScreens.Splash
import com.android.jetloom.utility.SPLASH

@Composable
fun Navigate(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SPLASH
    ){
        composable(SPLASH){
            Splash()
        }
    }
}