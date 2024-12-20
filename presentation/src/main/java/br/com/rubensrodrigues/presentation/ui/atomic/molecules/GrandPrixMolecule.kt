package br.com.rubensrodrigues.presentation.ui.atomic.molecules

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rubensrodrigues.presentation.R
import br.com.rubensrodrigues.presentation.ui.atomic.atoms.DateAtom
import br.com.rubensrodrigues.presentation.ui.theme.Dimen
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme
import br.com.rubensrodrigues.presentation.ui.theme.alphaGrey
import br.com.rubensrodrigues.presentation.utils.extensions.Padding

@Composable
fun GrandPrixMolecule(
    day: String,
    month: String,
    round: String,
    location: String,
    name: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp)
            .background(color = MaterialTheme.colorScheme.background)
            .clip(RoundedCornerShape(18.dp))
    ) {
        Row(
            modifier = Modifier.padding(Dimen.defaultMargin),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DateAtom(
                day = day,
                month = month,
            )
            Padding()
            VerticalDivider()
            Padding()
            Column(
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
        GrandPrixMolecule(
            day = "21",
            month = "Jul",
            round = "1",
            location = "Brazil",
            name = "Formula 1 Qatar Airways Hungarian grand prix 2023"
        )
    }
}