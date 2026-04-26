package me.safarov399.nablasim

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

external fun idealGas(p: Double, v: Double, n: Double, t: Double, targetVar: Int): Double

@Composable
fun ScreenSecond(onNavigateBack: () -> Unit) {
    var pressureState by remember { mutableStateOf(value = "") }
    var volumeState by remember { mutableStateOf(value = "") }
    var moleState by remember { mutableStateOf(value = "") }
    var temperatureState by remember { mutableStateOf(value = "") }
    var calculationState by remember { mutableIntStateOf(value = -1) }
    var answerState by remember { mutableStateOf(value = "") }
    var fieldsEnabled by remember { mutableIntStateOf(value = 1) }


    Column(modifier = Modifier.fillMaxSize()) {

        TextField(
            value = pressureState,
            onValueChange = { pressureState = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Pressure, Pa") },
            enabled = fieldsEnabled == 1
            )

        TextField(
            value = volumeState,
            onValueChange = { volumeState = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Volume, m³") },
            enabled = fieldsEnabled == 1


        )
        TextField(
            value = moleState,
            onValueChange = { moleState = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Moles") },
            enabled = fieldsEnabled == 1

        )
        TextField(
            value = temperatureState,
            onValueChange = { temperatureState = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Temperature, K") },
            enabled = fieldsEnabled == 1
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                when ("") {
                    pressureState -> calculationState = EosTargets.PRESSURE
                    volumeState -> calculationState = EosTargets.VOLUME
                    moleState -> calculationState = EosTargets.MOLES
                    temperatureState -> calculationState = EosTargets.TEMPERATURE
                }

                answerState = idealGas(
                    p = pressureState.toDoubleOrNull() ?: 0.0,
                    v = volumeState.toDoubleOrNull() ?: 0.0,
                    n = moleState.toDoubleOrNull() ?: 0.0,
                    t = temperatureState.toDoubleOrNull() ?: 0.0,
                    targetVar = calculationState
                ).toString()

                when (calculationState) {
                    EosTargets.PRESSURE -> pressureState = answerState
                    EosTargets.VOLUME -> volumeState = answerState
                    EosTargets.MOLES -> moleState = answerState
                    EosTargets.TEMPERATURE -> temperatureState = answerState
                }
                fieldsEnabled = 0
            }) {
                Text("Calculate")
            }
            Button(onClick = {
                pressureState = ""
                volumeState = ""
                moleState = ""
                temperatureState = ""
                fieldsEnabled = 1
            }) {
                Text("Clear")
            }
        }


        Button(onClick = onNavigateBack) {
            Text("Back")
        }
    }
}