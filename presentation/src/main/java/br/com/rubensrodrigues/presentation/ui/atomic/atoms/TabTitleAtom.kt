package br.com.rubensrodrigues.presentation.ui.atomic.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
fun TabTitleAtom(
    title: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = true,
    onClick: (() -> Unit)? = null,
) {
    Text(
        modifier = modifier
            .drawSegmentedBorder(
                strokeWidth = 4.dp,
                color = if (isSelected) red else Color.Transparent,
                cornerPercent = 40,
                borderTypes = setOf(
                    BorderType.Top,
                    BorderType.TopEnd,
                    BorderType.End
                )
            )
            .clickable(
                enabled = onClick != null,
                onClick = { onClick?.invoke() }
            )
            .padding(16.dp)
            .background(Color.Transparent),
        text = title,
        color = if (isSelected) white else white.copy(alpha = 0.45f),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleMedium
    )
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        TabTitleAtom(
            title = "Upcoming",
            Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
private fun PreviewUnselected() {
    F1CompanionTheme {
        TabTitleAtom(
            title = "Upcoming",
            isSelected = false,
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        )
    }
}
