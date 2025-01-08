package br.com.rubensrodrigues.presentation.ui.pages.standings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rubensrodrigues.domain.usecases.GetStandingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StandingsViewModel(
    private val getStandingsUseCase: GetStandingsUseCase,
): ViewModel() {
    private val _uiState = MutableStateFlow(StandingsUiState())
    val uiState: StateFlow<StandingsUiState> = _uiState.asStateFlow()

    fun fetchData() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            try {
                getStandingsUseCase(2024).apply {
                    _uiState.update {
                        it.copy(
                            drivers = first,
                            constructors = second,
                            isLoading = false
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(shouldShowError = true) }

            }
        }
    }

    fun onRetryClick() {
        _uiState.update { it.copy(shouldShowError = false) }
        fetchData()
    }
}