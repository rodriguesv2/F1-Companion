package br.com.rubensrodrigues.presentation.ui.atomic.templates

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.rubensrodrigues.domain.entities.Constructor
import br.com.rubensrodrigues.domain.entities.Driver
import br.com.rubensrodrigues.presentation.R
import br.com.rubensrodrigues.presentation.ui.atomic.atoms.TabTitleAtom
import br.com.rubensrodrigues.presentation.ui.atomic.atoms.TitleAtom
import br.com.rubensrodrigues.presentation.ui.atomic.organisms.ConstructorStandingOrganism
import br.com.rubensrodrigues.presentation.ui.atomic.organisms.DriverStandingOrganism
import br.com.rubensrodrigues.presentation.ui.atomic.organisms.ErrorOrganism
import br.com.rubensrodrigues.presentation.ui.atomic.organisms.LoadingOrganism
import br.com.rubensrodrigues.presentation.ui.theme.Dimen
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme
import br.com.rubensrodrigues.presentation.utils.extensions.Padding
import kotlinx.coroutines.launch

@Composable
fun StandingsTemplate(
    drivers: List<Driver>,
    constructors: List<Constructor>,
    isLoading: Boolean = false,
    shouldShowError: Boolean = false,
    onRetryClick: () -> Unit = {},
) {
    val pagerState = rememberPagerState { Page.entries.size }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TitleAtom(stringResource(R.string.standings_title))
        }
    ) {
        Column(
            Modifier
                .padding(it),
        ) {
            if (shouldShowError) {
                ErrorOrganism(onRetryClick)
                return@Column
            }
            if (isLoading) {
                LoadingOrganism()
                return@Column
            }
            Padding()
            TabRow(
                modifier = Modifier.fillMaxWidth().padding(horizontal = Dimen.defaultMargin),
                containerColor = Color.Transparent,
                selectedTabIndex = pagerState.currentPage,
                indicator = {},
                divider = {}
            ) {
                Page.entries.forEachIndexed { index, page ->
                    TabTitleAtom(
                        title = stringResource(page.title),
                        isSelected = pagerState.currentPage == index,
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                    )
                }
            }
            Padding()
            HorizontalPager(
                modifier = Modifier.fillMaxSize(),
                state = pagerState,
            ) { index ->
                val page = Page.entries[index]

                when (page) {
                    Page.DRIVERS -> DriverStandingOrganism(
                        drivers = drivers
                    )
                    Page.CONSTRUCTORS -> ConstructorStandingOrganism(
                        constructors = constructors
                    )
                }
            }
        }
    }
}

enum class Page(@StringRes val title: Int) {
    DRIVERS(title = R.string.drivers_title),
    CONSTRUCTORS(title = R.string.constructors_title)
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        StandingsTemplate(
            drivers = List(10) {
                Driver(
                    position = "1",
                    driver = "Carlos Sainz",
                    points = "100",
                    team = "Ferrari",
                )
            },
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