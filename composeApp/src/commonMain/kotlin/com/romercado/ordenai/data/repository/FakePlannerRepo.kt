package com.romercado.ordenai.data.repository

import com.romercado.ordenai.domain.repository.PlannerRepository
import com.romercado.ordenai.domain.model.DayPlan
import com.romercado.ordenai.domain.model.Task

class FakePlannerRepository : PlannerRepository {

    override suspend fun generatePlan(input: String): DayPlan {
        return DayPlan(
            date = "2026-02-19",
            tasks = listOf(
                Task("1", "Ir al médico", "09:00", "10:00"),
                Task("2", "Estudiar Kotlin", "11:00", "13:00")
            )
        )
    }
}