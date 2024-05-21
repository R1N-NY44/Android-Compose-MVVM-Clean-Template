package R1N.NY44.mvvm.system.navigation

import R1N.NY44.mvvm.ui.screen.ScreenContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

object NavigationGraph {
    const val ROOT = "root_graph"
    const val AUTH = "auth_graph"
    const val SCREEN = "screen_graph"
    const val DETAILS = "details_graph"
}
/////////////////////////////////////////////[Divider]/////////////////////////////////////////////
@Composable
fun NavigationRoot(navController: NavHostController) {
    NavHost(navController, startDestination = BottomBarNavList.Home.route, route = NavigationGraph.SCREEN){
        homeNavGraph(navController = navController)
        profileNavGraph(navController = navController)

        detailsNavGraph(navController = navController)
    }
}
/////////////////////////////////////////////[Divider]/////////////////////////////////////////////
fun NavGraphBuilder.homeNavGraph(navController: NavHostController){
    composable(route = BottomBarNavList.Home.route) {
        ScreenContent(
            name = BottomBarNavList.Home.route,
            onClick = {
                navController.navigate(NavigationGraph.DETAILS)
            }
        )
    }
}
fun NavGraphBuilder.profileNavGraph(navController: NavHostController){
    composable(route = BottomBarNavList.Profile.route) {
        ScreenContent(
            name = BottomBarNavList.Profile.route,
            onClick = {
                navController.navigate(NavigationGraph.DETAILS)
            }
        )
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = NavigationGraph.DETAILS,
        startDestination = DetailsScreen.BTM_DETAIL_PAGE.route
    ) {
        composable(route = DetailsScreen.BTM_DETAIL_PAGE.route) {
            ScreenContent(name = "Detail Page") {
                navController.navigate(DetailsScreen.BTM_SUB_DETAILS_PAGE.route)
            }
        }
        composable(route = DetailsScreen.BTM_SUB_DETAILS_PAGE.route) {
            ScreenContent(name = "Sub Detail Page") {}
        }
    }
}


sealed class DetailsScreen(val route: String) {
    data object BTM_DETAIL_PAGE : DetailsScreen(route = "DETAIL_PAGE_")
    data object BTM_SUB_DETAILS_PAGE : DetailsScreen(route = "DETAIL_PAGE_SUB")
}