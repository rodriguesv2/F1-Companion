package br.com.rubensrodrigues.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val AppSchemeColor = darkColorScheme(
    background = black,
    surface = alphaWhite,
    onBackground = white,
    onSurface = white,
    primary = red,
    secondary = grey,
)

@Composable
fun F1CompanionTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AppSchemeColor,
        typography = Typography,
        content = content
    )
}