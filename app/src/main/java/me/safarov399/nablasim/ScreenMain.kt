package me.safarov399.nablasim

import android.content.Context
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ScreenMain(onNavigateToSecond: () -> Unit, context: Context) {
    Button(onClick = onNavigateToSecond) { 
        Text(context.getString(R.string.EOS))
    }
}