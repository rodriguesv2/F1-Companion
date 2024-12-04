package br.com.rubensrodrigues.f1companion.presentation.atomic.organisms

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.rubensrodrigues.domain.entities.GrandPrix
import br.com.rubensrodrigues.f1companion.presentation.atomic.molecules.GrandPrixMolecule
import br.com.rubensrodrigues.f1companion.ui.theme.Dimen
import br.com.rubensrodrigues.f1companion.ui.theme.F1CompanionTheme

@Composable
fun GrandPrixListOrganism(
    items: List<GrandPrix>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = Dimen.defaultMargin)
    ) {
        items(items) {
            GrandPrixMolecule(
                days = it.days,
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
                    days = "21" to "23",
                    month = "Jul",
                    round = "1",
                    location = "Brazil",
                    name = "Formula 1 Qatar Airways Hungarian grand prix 2023"
                )
            }
        )
    }
}