package com.romercado.ordenai.presentation


import com.romercado.ordenai.domain.repository.PlannerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class PlannerViewModel(
    private val repository: PlannerRepository
) {

    private val _uiState = MutableStateFlow(PlannerUiState())
    val uiState: StateFlow<PlannerUiState> = _uiState

    suspend fun generatePlan(input: String) {

        _uiState.update { it.copy(isLoading = true, error = null) }

        try {
            val result = repository.generatePlan(input)

            _uiState.update {
                it.copy(
                    isLoading = false,
                    plan = result
                )
            }

        } catch (e: Exception) {
            _uiState.update {
                it.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}