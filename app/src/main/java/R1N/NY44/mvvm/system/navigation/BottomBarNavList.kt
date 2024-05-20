package R1N.NY44.mvvm.system.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarNavList(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    data object Home : BottomBarNavList(
        route = "HOME",
        title = "HOME",
        icon = Icons.Default.Home
    )
    data object Profile : BottomBarNavList(
        route = "PROFILE",
        title = "PROFILE",
        icon = Icons.Default.Person
    )
}