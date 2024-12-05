package br.com.rubensrodrigues.f1companion.presentation.atomic.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rubensrodrigues.f1companion.ui.theme.F1CompanionTheme
import br.com.rubensrodrigues.f1companion.ui.theme.white
import br.com.rubensrodrigues.f1companion.utils.SvgPathShape
import br.com.rubensrodrigues.f1companion.utils.drawSegmentedBorder

@Composable
fun PageTitleAtom(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier

    ) {
        Text(
            text = "Page Title",
            color = white,
        )
    }
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        PageTitleAtom(Modifier.fillMaxWidth())
    }
}

const val CUT_STROKE_PATH = "M336 45V17C336 8.16344 328.837 1 320 1H9.53675e-06"