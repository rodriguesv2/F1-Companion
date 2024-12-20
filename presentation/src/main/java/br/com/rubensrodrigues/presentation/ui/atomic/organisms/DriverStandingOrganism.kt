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
import br.com.rubensrodrigues.domain.entities.Driver
import br.com.rubensrodrigues.presentation.ui.atomic.molecules.DriverStandingItemMolecule
import br.com.rubensrodrigues.presentation.ui.theme.Dimen
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme

@Composable
fun DriverStandingOrganism(
    drivers: List<Driver>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(Dimen.defaultMargin),
        contentPadding = PaddingValues(Dimen.defaultMargin),
    ) {
        items(drivers) { driver ->
            DriverStandingItemMolecule(
                position = driver.position,
                driver = driver.driver,
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
        DriverStandingOrganism(
            drivers = List(10) {
                Driver(
                    position = "1",
                    driver = "Carlos Sainz",
                    points = "100",
                    team = "Ferrari",
                )
            }
        )
    }
}