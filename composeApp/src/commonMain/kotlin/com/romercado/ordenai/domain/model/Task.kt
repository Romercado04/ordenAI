package com.romercado.ordenai.domain.model

data class Task(
    val id: String,
    val title: String,
    val startTime: String,
    val endTime: String,
    val isCompleted: Boolean = false
)
