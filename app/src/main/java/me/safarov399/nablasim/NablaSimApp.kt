package me.safarov399.nablasim

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun NablaSimApp(mainActivity: MainActivity) {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Main) }

    when (currentScreen) {
        Screen.Main -> ScreenMain(
            onNavigateToSecond = { currentScreen = Screen.IdealGas },
            context = mainActivity
        )
        Screen.IdealGas -> IdealGasScreen(
            onNavigateBack = { currentScreen = Screen.Main },
            context = mainActivity
        )
    }
}