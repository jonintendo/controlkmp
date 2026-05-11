package com.joystick.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MapScreen() {
    Box(Modifier
        .fillMaxSize()
        .background(color = Color.Green)) {
        Column() {
            repeat(10) {
                Text("MAAAAPAAAA")
            }
        }
    }
}