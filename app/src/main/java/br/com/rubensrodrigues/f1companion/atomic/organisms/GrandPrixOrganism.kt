package br.com.rubensrodrigues.f1companion.atomic.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rubensrodrigues.f1companion.R
import br.com.rubensrodrigues.f1companion.atomic.molecules.DateMolecule
import br.com.rubensrodrigues.f1companion.ui.theme.Dimen
import br.com.rubensrodrigues.f1companion.ui.theme.F1CompanionTheme
import br.com.rubensrodrigues.f1companion.ui.theme.alphaGrey
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
            .clip(RoundedCornerShape(18.dp))
            .onGloballyPositioned { coordinates ->
                surfaceHeight = with(localDensity) { coordinates.size.height.toDp() }
            }
    ) {
        Row(
            modifier = Modifier.padding(Dimen.defaultMargin),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DateMolecule(
                days = days,
                month = month,
            )
            Padding()
            VerticalDivider(modifier = Modifier.height(surfaceHeight))
            Padding()
            Column(
                modifier = Modifier.height(surfaceHeight),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(stringResource(R.string.grand_prix_round, round))
                Text(
                    text = location,
                    style = MaterialTheme.typography.titleSmall,
                )
                Text(
                    text = name,
                    color = alphaGrey,
                    style = TextStyle(lineHeight = 16.sp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    F1CompanionTheme {
        GrandPrixOrganism(
            days = "21 - 23",
            month = "Jul",
            round = "1",
            location = "Brazil",
            name = "Formula 1 Qatar Airways Hungarian grand prix 2023"
        )
    }
}