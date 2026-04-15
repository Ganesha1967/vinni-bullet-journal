package org.bullet.journal.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val JournalColorScheme =
    lightColorScheme(
        primary = InkColor,
        onPrimary = ParchmentLight,
        primaryContainer = ParchmentDark,
        onPrimaryContainer = InkColor,
        background = ParchmentDark,
        onBackground = InkColor,
        surface = ParchmentLight,
        onSurface = InkColor,
        secondary = QuestGold,
        tertiary = StaminaGreen,
    )

@Composable
fun JournalTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = JournalColorScheme,
        typography = JournalTypography,
        shapes = JournalShapes,
        content = content,
    )
}
