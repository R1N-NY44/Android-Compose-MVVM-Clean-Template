package org.d3if3062.mobpro1.asessmen3.system.navigation


sealed class Screen(val route: String) {
    data object Base : Screen("home")
}