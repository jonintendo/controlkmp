package com.joystick

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

class ControlButton(
    var description: String = "button description",
    var action: () -> Unit = { println("take action") },
    var modifier: Modifier = Modifier.background(color = Color.Transparent),
    var icon: ImageVector? = null,
    var direction: Direction = Direction.None,
    var actionRelease: () -> Unit  = { println("$description release") },
) {
}

enum class Direction() {
    Up,
    Left,
    Right,
    Down,
    None
}