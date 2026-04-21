package me.safarov399.nablasim

sealed class Screen {
    data object Main : Screen()
    data object Second : Screen()
}