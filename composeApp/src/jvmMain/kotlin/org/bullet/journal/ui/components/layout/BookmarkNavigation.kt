package org.bullet.journal.ui.components.layout

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import org.bullet.journal.core.navigation.Destinations
import org.bullet.journal.data.models.navigationBookmarks
import org.bullet.journal.ui.components.widgets.TopTab

@Composable
fun TopTabs(
    currentDestination: NavDestination?,
    onNavigate: (Destinations) -> Unit,
) {
    Row(
        modifier =
            Modifier
                .padding(end = 40.dp)
                .offset(y = (-70).dp),
    ) {
        navigationBookmarks.forEach { bookmark ->
            val isSelected = currentDestination?.hasRoute(bookmark.kClass) ?: false

            TopTab(
                data = bookmark,
                isSelected = isSelected,
                onClick = { onNavigate(bookmark.destinations) },
            )
            Spacer(Modifier.width(8.dp))
        }
    }
}
