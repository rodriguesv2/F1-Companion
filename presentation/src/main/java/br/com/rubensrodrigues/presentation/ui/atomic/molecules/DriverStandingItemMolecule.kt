package br.com.rubensrodrigues.presentation.ui.atomic.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rubensrodrigues.presentation.R
import br.com.rubensrodrigues.presentation.ui.theme.Dimen
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme
import br.com.rubensrodrigues.presentation.ui.theme.alphaGrey

@Composable
fun DriverStandingItemMolecule(
    position: String,
    driver: String,
    points: String,
    team: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(color = MaterialTheme.colorScheme.background)
            .clip(RoundedCornerShape(18.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimen.defaultMargin),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = position,
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    buildAnnotatedString {
                        append(
                            AnnotatedString(
                                driver
                                    .split(" ")
                                    .first(),
                                spanStyle = MaterialTheme.typography.titleSmall.toSpanStyle()
                            )
                        )
                        append("\n")
                        append(
                            AnnotatedString(
                                driver
                                    .split(" ")
                                    .last(),
                                spanStyle = MaterialTheme.typography.titleMedium.toSpanStyle()
                            )
                        )
                    }
                )
                Text(
                    text = team,
                    color = alphaGrey,
                    style = TextStyle(lineHeight = 16.sp)
                )
            }
            Text(
                modifier = Modifier.align(alignment = Alignment.Bottom),
                text = stringResource(
                    R.string.points,
                    points
                ),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    F1CompanionTheme {
        DriverStandingItemMolecule(
            position = "1",
            driver = "Carlos Sainz",
            points = "100",
            team = "Ferrari"
        )
    }
}