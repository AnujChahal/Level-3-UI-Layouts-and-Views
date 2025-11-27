package com.synac.bmicalculator.presentation.historyscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.synac.bmicalculator.domain.model.BMIRecord

@Composable
fun HistoryScreen(navController: NavController, history: List<BMIRecord>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("History", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(history) { record ->
                Text(
                    "BMI: %.2f (%s)".format(record.value, record.category),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Back")
        }
    }
}
