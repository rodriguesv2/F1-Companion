package br.com.rubensrodrigues.f1companion.atomic.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rubensrodrigues.f1companion.ui.theme.F1CompanionTheme
import br.com.rubensrodrigues.f1companion.ui.theme.white

@Composable
fun MonthAtom(
    month: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(size = 20.dp))
            .background(color = white.copy(alpha = 0.1f)),
    ) {
        Text(
            modifier = Modifier.padding(
                horizontal = 14.dp,
                vertical = 5.dp
            ),
            text = month,
            style = TextStyle(color = white)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        MonthAtom("Jul")
    }
}