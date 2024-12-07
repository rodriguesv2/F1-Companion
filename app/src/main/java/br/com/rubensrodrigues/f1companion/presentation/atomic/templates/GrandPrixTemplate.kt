package br.com.rubensrodrigues.f1companion.presentation.atomic.templates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.rubensrodrigues.domain.entities.GrandPrix
import br.com.rubensrodrigues.f1companion.R
import br.com.rubensrodrigues.f1companion.presentation.atomic.atoms.PageTitleAtom
import br.com.rubensrodrigues.f1companion.presentation.atomic.atoms.TitleAtom
import br.com.rubensrodrigues.f1companion.presentation.atomic.organisms.GrandPrixListOrganism
import br.com.rubensrodrigues.f1companion.ui.theme.Dimen
import br.com.rubensrodrigues.f1companion.ui.theme.F1CompanionTheme
import br.com.rubensrodrigues.f1companion.utils.extensions.Padding

@Composable
fun GrandPrixTemplate(
    gPs: List<GrandPrix>,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TitleAtom(stringResource( R.string.racing_title))
        }
    ) {
        Column(
            modifier = modifier
                .padding(it)
                .fillMaxSize()
        ) {
            PageTitleAtom(
                modifier = Modifier.fillMaxWidth().padding(Dimen.defaultMargin),
                title = stringResource(R.string.upcoming_gp_pager_title)
            )
            GrandPrixListOrganism(gPs)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        GrandPrixTemplate(
            List(20) {
                GrandPrix(
                    "21" to "23",
                    "Nov",
                    "20",
                    "Brazil",
                    "GP São Paulo Lenovo"
                )
            }
        )
    }
}