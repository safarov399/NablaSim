package me.safarov399.nablasim

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

external fun idealGasResidue(p: Double, v: Double, n: Double, t: Double, targetVar: Int): Double

@Composable
fun ScreenSecond(onNavigateBack: () -> Unit) {
    Button(onClick = onNavigateBack) {
        Text("Back")
    }
    Text(idealGasResidue(101325.0, 0.0224, 2.0, 273.0, EosTargets.PRESSURE).toString())
}