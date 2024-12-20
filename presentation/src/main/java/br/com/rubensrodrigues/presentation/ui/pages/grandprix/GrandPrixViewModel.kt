package br.com.rubensrodrigues.presentation.ui.pages.grandprix

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rubensrodrigues.domain.usecases.GetGrandPrixUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GrandPrixViewModel(
    private val getGrandPrixUseCase: GetGrandPrixUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(GrandPrixUiState())
    val uiState: StateFlow<GrandPrixUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            getGrandPrixUseCase(2024).apply {
                _uiState.update {
                    it.copy(
                        grandPrixList = this,
                        isLoading = false
                    )
                }
            }
        }
    }
}