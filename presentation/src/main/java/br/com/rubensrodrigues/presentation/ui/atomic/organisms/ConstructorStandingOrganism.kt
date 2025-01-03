package br.com.rubensrodrigues.presentation.ui.atomic.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.rubensrodrigues.domain.entities.Constructor
import br.com.rubensrodrigues.presentation.ui.atomic.molecules.ConstructorStandingItemMolecule
import br.com.rubensrodrigues.presentation.ui.theme.Dimen
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme

@Composable
fun ConstructorStandingOrganism(
    constructors: List<Constructor>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(Dimen.defaultMargin),
        contentPadding = PaddingValues(Dimen.defaultMargin),
    ) {
        items(constructors) { driver ->
            ConstructorStandingItemMolecule(
                position = driver.position,
                points = driver.points,
                team = driver.team
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        ConstructorStandingOrganism(
            constructors = List(10) {
                Constructor(
                    position = "1",
                    points = "100",
                    team = "Ferrari",
                )
            }
        )
    }
}