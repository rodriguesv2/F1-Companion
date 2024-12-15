package br.com.rubensrodrigues.presentation.ui.atomic.templates

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
import br.com.rubensrodrigues.presentation.R
import br.com.rubensrodrigues.presentation.ui.atomic.atoms.PageTitleAtom
import br.com.rubensrodrigues.presentation.ui.atomic.atoms.TitleAtom
import br.com.rubensrodrigues.presentation.ui.atomic.organisms.GrandPrixListOrganism
import br.com.rubensrodrigues.presentation.ui.atomic.organisms.LoadingOrganism
import br.com.rubensrodrigues.presentation.ui.theme.Dimen
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme

@Composable
fun GrandPrixTemplate(
    grandPrixList: List<GrandPrix>,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false
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
            if (isLoading) {
                LoadingOrganism()
                return@Scaffold
            }
            GrandPrixListOrganism(grandPrixList)
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
                    days = "21" to "23",
                    month = "Nov",
                    round = "20",
                    location = "Brazil",
                    name = "GP São Paulo Lenovo"
                )
            }
        )
    }
}

@Preview
@Composable
private fun PreviewLoading() {
    F1CompanionTheme {
        GrandPrixTemplate(
            listOf(),
            isLoading = true,
        )
    }
}