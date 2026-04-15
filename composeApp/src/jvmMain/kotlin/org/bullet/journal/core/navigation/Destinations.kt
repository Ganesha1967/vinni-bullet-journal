package org.bullet.journal.core.navigation

import kotlinx.serialization.Serializable

sealed interface Destinations {
    @Serializable data object Home : Destinations

    @Serializable data object Tracker : Destinations

    @Serializable data object Profile : Destinations

    @Serializable data object Stats : Destinations

    @Serializable data object Mood : Destinations

    @Serializable data object Settings : Destinations
}
