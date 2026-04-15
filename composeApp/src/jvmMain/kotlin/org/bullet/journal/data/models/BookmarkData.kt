package org.bullet.journal.data.models

import androidx.compose.ui.graphics.Color
import org.bullet.journal.core.navigation.Destinations
import kotlin.reflect.KClass

data class BookmarkData(
    val destinations: Destinations,
    val kClass: KClass<out Destinations>,
    val label: String,
    val color: Color,
)

val navigationBookmarks =
    listOf(
        BookmarkData(Destinations.Home, Destinations.Home::class, "Home", Color(0xFF9D8189)),
        BookmarkData(Destinations.Tracker, Destinations.Tracker::class, "Tracker", Color(0xFF8FBC8F)),
        BookmarkData(Destinations.Profile, Destinations.Profile::class, "Profile", Color(0xFFDDA15E)),
        BookmarkData(Destinations.Stats, Destinations.Stats::class, "Stats", Color(0xFFBC6C25)),
        BookmarkData(Destinations.Mood, Destinations.Mood::class, "Mood", Color(0xFFD4A5A5)),
        BookmarkData(Destinations.Settings, Destinations.Settings::class, "Settings", Color(0xFF7C8CAC)),
    )
