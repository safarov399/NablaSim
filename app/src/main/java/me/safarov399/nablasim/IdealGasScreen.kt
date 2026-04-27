package me.safarov399.nablasim

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

external fun idealGas(p: Double, v: Double, n: Double, t: Double, targetVar: Int): Double

@Composable
fun IdealGasScreen(onNavigateBack: () -> Unit, context: Context) {
    var pressureState by remember { mutableStateOf(value = "") }
    var volumeState by remember { mutableStateOf(value = "") }
    var moleState by remember { mutableStateOf(value = "") }
    var temperatureState by remember { mutableStateOf(value = "") }
    var calculationState by remember { mutableIntStateOf(value = -1) }
    var answerState by remember { mutableStateOf(value = "") }
    var fieldsEnabled by remember { mutableStateOf(value = true) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = pressureState,
            onValueChange = { pressureState = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(context.getString(R.string.pressure_pa)) },
            enabled = fieldsEnabled
        )

        TextField(
            value = volumeState,
            onValueChange = { volumeState = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(context.getString(R.string.volume_m3)) },
            enabled = fieldsEnabled

        )
        TextField(
            value = moleState,
            onValueChange = { moleState = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(context.getString(R.string.moles)) },
            enabled = fieldsEnabled

        )
        TextField(
            value = temperatureState,
            onValueChange = { temperatureState = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(context.getString(R.string.temperature_k)) },
            enabled = fieldsEnabled
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                calculationState = when ("") {
                    pressureState -> EosTargets.PRESSURE
                    volumeState -> EosTargets.VOLUME
                    moleState -> EosTargets.MOLES
                    temperatureState -> EosTargets.TEMPERATURE
                    else -> -1
                }
                if (calculationState != -1) {
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
                    fieldsEnabled = false
                } else {
                    Toast.makeText(
                        context,
                        context.getString(R.string.at_least_one_field_must_be_empty),
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }) {
                Text(context.getString(R.string.calculate))
            }
            Button(onClick = {
                pressureState = ""
                volumeState = ""
                moleState = ""
                temperatureState = ""
                fieldsEnabled = true
            }) {
                Text(context.getString(R.string.clear))
            }
            Button(onClick = {
                fieldsEnabled = true
            }) {
                Text(context.getString(R.string.edit))
            }
        }


        Button(onClick = onNavigateBack) {
            Text(text = context.getString(R.string.back))
        }
    }
}