package br.com.rubensrodrigues.f1companion.atomic.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rubensrodrigues.f1companion.atomic.molecules.DateMolecule
import br.com.rubensrodrigues.f1companion.ui.theme.F1CompanionTheme
import br.com.rubensrodrigues.f1companion.utils.extensions.Padding

@Composable
fun GrandPrixOrganism(
    days: String,
    month: String,
    round: String,
    location: String,
    name: String,
    modifier: Modifier = Modifier
) {
    val localDensity = LocalDensity.current
    var surfaceHeight by remember { mutableStateOf(0.dp) }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.background)
            .onGloballyPositioned { coordinates ->
                surfaceHeight = with(localDensity) { coordinates.size.height.toDp() }
            }
    ) {
        Row {
            DateMolecule(
                days = days,
                month = month,
            )
            Padding()
            VerticalDivider(modifier = Modifier.height(surfaceHeight))
            Padding()

        }
    }
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        GrandPrixOrganism(
            days = "21 - 23",
            month = "Jul",
            round = "1",
            location = "São Paulo",
            name = "São Paulo Grand Prix"
        )
    }
}