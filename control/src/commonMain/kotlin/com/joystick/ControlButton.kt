package com.joystick

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.DrawableResource

data class ControlButton(
    var description: String = "button description",
    var action: () -> Unit = { println("take action") },
    var modifier: Modifier = Modifier.background(color = Color.Transparent),
    var icon: DrawableResource? = null,
    var actionRelease: () -> Unit  = { println("$description release") },
)

