package com.joystick

import org.jetbrains.compose.resources.DrawableResource
import androidx.compose.runtime.Composable

data class ControlScreen(
    val name: String,
    val icon: DrawableResource,
    val screen: @Composable () -> Unit
)