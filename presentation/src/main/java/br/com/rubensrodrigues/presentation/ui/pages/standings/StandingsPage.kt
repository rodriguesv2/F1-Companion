package br.com.rubensrodrigues.presentation.ui.pages.standings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import br.com.rubensrodrigues.presentation.ui.atomic.templates.StandingsTemplate

@Composable
fun StandingsPage(
    viewModel: StandingsViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    StandingsTemplate(
        drivers = uiState.drivers,
        constructors = uiState.constructors,
        isLoading = uiState.isLoading,
        shouldShowError = uiState.shouldShowError,
        onRetryClick = viewModel::onRetryClick,
    )
}