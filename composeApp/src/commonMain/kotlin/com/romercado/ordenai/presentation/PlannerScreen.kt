package com.romercado.ordenai.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.romercado.ordenai.data.repository.FakePlannerRepository
import kotlinx.coroutines.launch

@Composable
fun PlannerScreen() {

    val repository = FakePlannerRepository()
    val viewModel = PlannerViewModel(repository)

    val uiState by viewModel.uiState.collectAsState()

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = {
            scope.launch {
                viewModel.generatePlan("Tengo que estudiar y entrenar")
            }
        }) {
            Text("Generar Plan")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (uiState.isLoading) {
            CircularProgressIndicator()
        }

        uiState.plan?.tasks?.forEach { task ->
            Text("${task.startTime} - ${task.title}")
        }

        uiState.error?.let {
            Text("Error: $it")
        }
    }
}