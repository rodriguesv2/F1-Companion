package br.com.rubensrodrigues.presentation.ui.atomic.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme
import br.com.rubensrodrigues.presentation.ui.theme.red
import br.com.rubensrodrigues.presentation.ui.theme.white
import br.com.rubensrodrigues.presentation.utils.BorderType
import br.com.rubensrodrigues.presentation.utils.drawSegmentedBorder

@Composable
fun PageTitleAtom(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier
            .drawSegmentedBorder(
                strokeWidth = 4.dp,
                color = red,
                cornerPercent = 40,
                borderTypes = setOf(
                    BorderType.Top,
                    BorderType.TopEnd,
                    BorderType.End
                )
            )
            .padding(20.dp)
            .background(Color.Transparent),
        text = title,
        color = white,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleMedium
    )
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        PageTitleAtom(title = "Upcoming", Modifier.fillMaxWidth())
    }
}
