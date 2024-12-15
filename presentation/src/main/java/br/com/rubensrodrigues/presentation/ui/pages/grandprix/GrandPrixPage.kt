package br.com.rubensrodrigues.presentation.ui.pages.grandprix

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import br.com.rubensrodrigues.presentation.ui.atomic.templates.GrandPrixTemplate

@Composable
fun GrandPrixPage(viewModel: GrandPrixViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    GrandPrixTemplate(
        grandPrixList = uiState.grandPrixList,
        isLoading = uiState.isLoading,
    )
}