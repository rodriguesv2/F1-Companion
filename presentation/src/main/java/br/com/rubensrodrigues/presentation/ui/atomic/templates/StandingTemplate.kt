package br.com.rubensrodrigues.presentation.ui.atomic.templates

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme

@Composable
fun StandingTemplate(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState { 2 }

    HorizontalPager(
        state = pagerState
    ) { page ->
        val color = when (page) {
            0 -> Color.Blue
            else -> Color.Red
        }
        Box(
            modifier = Modifier.fillMaxSize().background(color = color)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        StandingTemplate()
    }
}