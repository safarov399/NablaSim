package me.safarov399.nablasim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.safarov399.nablasim.ui.theme.NablaSimTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NablaSimTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = idealGasResidue(101325.0, 0.0224, 2.0, 273.0, EosTargets.PRESSURE).toString(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    external fun idealGasResidue(p: Double, v: Double, n: Double, t: Double, targetVar: Int): Double
    companion object {
        init {
            System.loadLibrary("chem_simulation")
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}
