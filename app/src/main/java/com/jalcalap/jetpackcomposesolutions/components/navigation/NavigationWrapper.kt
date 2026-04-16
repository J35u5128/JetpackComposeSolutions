package com.jalcalap.jetpackcomposesolutions.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jalcalap.jetpackcomposesolutions.components.navigation.examples.HomeScreen
import com.jalcalap.jetpackcomposesolutions.components.navigation.examples.LoginScreen


@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login){
        composable <Login>{
            LoginScreen(navigateToDetail = {navController.navigate(Home)})
        }
        composable <Home>{
            HomeScreen(navigateBack = {navController.popBackStack()})
        }
    }
}