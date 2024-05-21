package R1N.NY44.mvvm.ui.widgets

import R1N.NY44.mvvm.system.navigation.BottomBarNavList
import R1N.NY44.mvvm.ui.component.BottomNavItem
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

class BottomBar {
}

@Composable
fun BottomBarWidget(navController: NavHostController) {
    val screens = listOf(
        BottomBarNavList.Home,
        BottomBarNavList.Profile,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        NavigationBar {
            screens.forEach { screen ->
                BottomNavItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}