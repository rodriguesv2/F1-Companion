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
import br.com.rubensrodrigues.domain.entities.GrandPrix
import br.com.rubensrodrigues.presentation.ui.atomic.molecules.GrandPrixMolecule
import br.com.rubensrodrigues.presentation.ui.theme.Dimen
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme

@Composable
fun GrandPrixListOrganism(
    items: List<GrandPrix>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(Dimen.defaultMargin),
        contentPadding = PaddingValues(Dimen.defaultMargin),
    ) {
        items(items) {
            GrandPrixMolecule(
                day = it.day,
                month = it.month,
                round = it.round,
                location = it.location,
                name = it.name
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        GrandPrixListOrganism(
            items = List(10) {
                GrandPrix(
                    day = "21",
                    month = "Jul",
                    round = "1",
                    location = "Brazil",
                    name = "Formula 1 Qatar Airways Hungarian grand prix 2023"
                )
            }
        )
    }
}