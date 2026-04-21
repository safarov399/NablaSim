package me.safarov399.nablasim

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ScreenMain(onNavigateToSecond: () -> Unit) {
    Button(onClick = onNavigateToSecond) { 
        Text("Hello")
    }
}