package br.com.rubensrodrigues.presentation.ui.pages.grandprix

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import br.com.rubensrodrigues.presentation.ui.atomic.templates.GrandPrixTemplate

@Composable
fun GrandPrixPage(viewModel: GrandPrixViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    GrandPrixTemplate(
        grandPrixList = uiState.grandPrixList,
        isLoading = uiState.isLoading,
        shouldShowError = uiState.shouldShowError,
        onRetryClick = viewModel::onRetryClick,
    )
}