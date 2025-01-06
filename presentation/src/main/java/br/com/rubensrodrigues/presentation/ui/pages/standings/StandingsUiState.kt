package br.com.rubensrodrigues.presentation.ui.pages.standings

import br.com.rubensrodrigues.domain.entities.Constructor
import br.com.rubensrodrigues.domain.entities.Driver

data class StandingsUiState(
    val isLoading: Boolean = false,
    val drivers: List<Driver> = emptyList(),
    val constructors: List<Constructor> = emptyList(),
)
