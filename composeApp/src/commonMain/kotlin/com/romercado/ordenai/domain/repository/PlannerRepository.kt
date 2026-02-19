package com.romercado.ordenai.domain.repository

import com.romercado.ordenai.domain.model.DayPlan
interface PlannerRepository {
    suspend fun generatePlan(input: String): DayPlan
}