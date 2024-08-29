package com.carfax.demo.ui

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.carfax.demo.MainRoutes
import com.carfax.demo.cars.list.CarsScreen

@Composable
fun MainNavigation(
    callCarDealer: (phone: String) -> Unit,
) {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(
            navController = navController,
            startDestination = MainRoutes.CarList.key,
            enterTransition = {
                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            popEnterTransition = {
                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)
            },
            popExitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)
            }
        ) {
            composable(MainRoutes.CarList.key) {
                Cars(
                    callCarDealer = callCarDealer,
                    onCarSelected = {  },
                )
            }
            composable(MainRoutes.CarDetails().key) {
                Cars(
                    callCarDealer = callCarDealer,
                    onCarSelected = {  },
                )
            }
        }
    }
}

@Composable
private fun Cars(
    callCarDealer: (vin: String) -> Unit,
    onCarSelected: (phone: String) -> Unit,
) {
    CarsScreen(
        callCarDealer = callCarDealer,
        onCarSelected = onCarSelected
    )
}