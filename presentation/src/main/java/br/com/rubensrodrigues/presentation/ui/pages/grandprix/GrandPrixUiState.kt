package br.com.rubensrodrigues.presentation.ui.pages.grandprix

import br.com.rubensrodrigues.domain.entities.GrandPrix

data class GrandPrixUiState(
    val grandPrixList: List<GrandPrix> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)