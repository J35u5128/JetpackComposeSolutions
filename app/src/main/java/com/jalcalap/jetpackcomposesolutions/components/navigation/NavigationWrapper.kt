package com.jalcalap.jetpackcomposesolutions.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jalcalap.jetpackcomposesolutions.components.navigation.examples.DetailScreen
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
            HomeScreen(navigateBack = {navController.popBackStack()}, navigateToDetail = { id, test ->navController.navigate(Detail(id=id, test = test))})
        }
        composable <Detail>{ navBackStackEntry ->
            var detail = navBackStackEntry.toRoute<Detail>()
            DetailScreen(detail.id)
        }
    }
}