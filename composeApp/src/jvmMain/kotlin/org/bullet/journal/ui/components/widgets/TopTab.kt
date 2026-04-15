package org.bullet.journal.ui.components.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.bullet.journal.data.models.BookmarkData

@Composable
fun TopTab(
    data: BookmarkData,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val yOffset = if (isSelected) 5.dp else 20.dp
    val tabShape =
        androidx.compose.foundation.shape
            .RoundedCornerShape(16.dp)

    Surface(
        modifier =
            Modifier
                .width(65.dp)
                .height(80.dp)
                .offset(y = yOffset)
                .clickable(onClick = onClick),
        color = data.color,
        shape = tabShape,
        shadowElevation = if (isSelected) 4.dp else 10.dp,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize().padding(8.dp),
        ) {
            Text(
                text = data.label,
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}
