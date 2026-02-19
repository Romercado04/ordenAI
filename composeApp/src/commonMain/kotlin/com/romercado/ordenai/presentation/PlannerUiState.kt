package com.romercado.ordenai.presentation

import com.romercado.ordenai.domain.model.DayPlan

data class PlannerUiState(
    val isLoading: Boolean = false,
    val plan: DayPlan? = null,
    val error: String? = null
)