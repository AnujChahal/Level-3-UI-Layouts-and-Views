package com.synac.bmicalculator.presentation.homescreen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.synac.bmicalculator.domain.model.BMIRecord

@Composable
fun HomeScreen(navController: NavController, history: MutableList<BMIRecord>) {
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("BMI Calculator", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = height, onValueChange = { height = it }, label = { Text("Height (cm)") })

        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = weight, onValueChange = { weight = it }, label = { Text("Weight (kg)") })

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val h = height.toFloatOrNull()
            val w = weight.toFloatOrNull()
            if (h != null && w != null) {
                val bmi = w / ((h / 100) * (h / 100))
                val category = when {
                    bmi < 18.5 -> "Underweight"
                    bmi < 24.9 -> "Normal"
                    bmi < 29.9 -> "Overweight"
                    else -> "Obese"
                }
                result = "BMI: %.2f (%s)".format(bmi, category)
                history.add(BMIRecord(bmi, category))
            }
        }) {
            Text("Calculate")
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(result, style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("history") }) {
            Text("View History")
        }
    }
}
