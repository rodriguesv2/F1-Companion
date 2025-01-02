package br.com.rubensrodrigues.presentation.ui.atomic.templates

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.rubensrodrigues.presentation.R
import br.com.rubensrodrigues.presentation.ui.atomic.atoms.TabTitleAtom
import br.com.rubensrodrigues.presentation.ui.atomic.atoms.TitleAtom
import br.com.rubensrodrigues.presentation.ui.theme.Dimen
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme
import br.com.rubensrodrigues.presentation.utils.extensions.Padding
import kotlinx.coroutines.launch

@Composable
fun StandingTemplate() {
    val pagerState = rememberPagerState { 2 }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TitleAtom(stringResource(R.string.standings_title))
        }
    ) {
        Column(
            Modifier
                .padding(it)
                .padding(horizontal = Dimen.defaultMargin),
        ) {
            Padding()
            TabRow(
                modifier = Modifier.fillMaxWidth(),
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
            ) { page ->

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
        StandingTemplate()
    }
}