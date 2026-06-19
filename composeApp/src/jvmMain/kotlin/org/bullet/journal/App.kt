package org.bullet.journal

import androidx.compose.runtime.*
import androidx.navigation.compose.*
import org.bullet.journal.core.navigation.Destinations
import org.bullet.journal.core.theme.JournalTheme
import org.bullet.journal.ui.components.Placeholder
import org.bullet.journal.ui.components.layout.BookLayout
import org.bullet.journal.ui.screens.home.HomeScreen

@Composable
fun App() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    JournalTheme {
        BookLayout(
            currentDestination = currentDestination,
            onNavigate = { dest ->
                navController.navigate(dest) {
                    popUpTo<Destinations.Home> { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            },
        ) {
            NavHost(
                navController = navController,
                startDestination = Destinations.Home,
            ) {
                composable<Destinations.Home> { HomeScreen() }
                composable<Destinations.Tracker> { Placeholder("Tracker") }
                composable<Destinations.Profile> { Placeholder("Profile") }
                composable<Destinations.Stats> { Placeholder("Stats") }
                composable<Destinations.Mood> { Placeholder("Mood") }
                composable<Destinations.Settings> { Placeholder("Settings") }
            }
        }
    }
}
