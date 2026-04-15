package org.bullet.journal.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

private val Primary = Color(0xFF4E342E)

@Composable
fun HomeScreen() {
    val today = LocalDate.now()
    val monthName =
        today
            .month
            .getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru"))
            .replaceFirstChar { it.uppercase() }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
        contentPadding = PaddingValues(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        item { GreetingSection(today, monthName) }
    }
}

// --- Sections ---

@Composable
private fun GreetingSection(
    today: LocalDate,
    month: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = " Доброй ночи, Умняшка!",
            style =
                MaterialTheme.typography.headlineSmall.copy(
                    fontFamily = FontFamily.Serif,
                    color = Primary,
                ),
        )
        Text(
            text = "${today.dayOfMonth} $month - Начинающий герой",
            fontSize = 14.sp,
            color = Primary.copy(0.6f),
        )
    }
}
