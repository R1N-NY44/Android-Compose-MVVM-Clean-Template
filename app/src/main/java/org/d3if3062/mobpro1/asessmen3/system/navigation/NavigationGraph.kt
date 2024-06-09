package org.d3if3062.mobpro1.asessmen3.system.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.d3if3062.mobpro1.asessmen3.ui.screen.ScreenContent

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Base.route
    ) {
        /*----------------[Main Route]----------------*/

        composable(route = Screen.Base.route) {
            ScreenContent(
                name = Screen.Base.route,
                onClick = { }
            )
        }
//        composable(route = Screen.History.route) {
//            ScreenContent(
//                name = Screen.Task.route,
//                onClick = { }
//            )
//        }
    }
}