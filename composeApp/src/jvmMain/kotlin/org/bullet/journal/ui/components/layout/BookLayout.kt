package org.bullet.journal.ui.components.layout

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import org.bullet.journal.core.navigation.Destinations

private val TableColor = Color(0xFF05053B)
private val PaperColor = Color(0xFFFFF9F0)
private val BorderColor = Color(0xFF4E342E).copy(alpha = 0.5f)
private val BookShape = RoundedCornerShape(24.dp)

@Composable
fun BookLayout(
    currentDestination: NavDestination?,
    onNavigate: (Destinations) -> Unit,
    content: @Composable () -> Unit,
) {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(TableColor)
                .padding(top = 80.dp, start = 40.dp, end = 40.dp, bottom = 40.dp),
        contentAlignment = Alignment.TopEnd,
    ) {
        TopTabs(
            currentDestination = currentDestination,
            onNavigate = onNavigate,
        )

        PaperStack()

        MainPage(
            displayKey = currentDestination?.route ?: "default",
            content = content,
        )
    }
}

@Composable
private fun MainPage(
    displayKey: String,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = PaperColor,
        shape = BookShape,
        border = BorderStroke(1.dp, BorderColor.copy(alpha = 0.2f)),
        shadowElevation = 12.dp,
    ) {
        Box(Modifier.fillMaxSize()) {
            AnimatedContent(
                targetState = displayKey,
                transitionSpec = {
                    (fadeIn(tween(400)) + scaleIn(initialScale = 0.95f))
                        .togetherWith(fadeOut(tween(400)))
                },
            ) {
                Box(Modifier.fillMaxSize()) {
                    content()
                }
            }

            Box(
                modifier =
                    Modifier
                        .fillMaxHeight()
                        .width(40.dp)
                        .align(Alignment.Center)
                        .background(
                            Brush.horizontalGradient(
                                0.0f to Color.Transparent,
                                0.45f to Color.Black.copy(alpha = 0.08f),
                                0.5f to Color.Black.copy(alpha = 0.12f),
                                0.55f to Color.Black.copy(alpha = 0.08f),
                                1.0f to Color.Transparent,
                            ),
                        ),
            )
        }
    }
}

@Composable
private fun PaperStack() {
    repeat(5) { index ->
        val xOffset = (index + 1) * 5
        val yOffset = (index + 1) * 2

        Surface(
            modifier =
                Modifier
                    .fillMaxSize()
                    .offset(x = xOffset.dp, y = yOffset.dp),
            color = Color(0xFFF5F5F5),
            shape = BookShape,
            border = BorderStroke(1.dp, Color.Black.copy(0.4f)),
        ) {}
    }
}
