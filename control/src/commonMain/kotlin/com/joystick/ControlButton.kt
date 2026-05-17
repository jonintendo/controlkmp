package com.joystick

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.DrawableResource

data class ControlButton(
    var action: (positionx: Float , positiony: Float) -> Unit = { positionx, positiony -> println("take action x: $positionx,y: $positiony") },
    var modifier: Modifier = Modifier.background(color = Color.Transparent),
    var description: String? = null,
    var icon: DrawableResource? = null,
    var actionRelease: (positionx: Float, positiony: Float) -> Unit = { positionx, positiony ->
        println(
            "take action x: $positionx,y: $positiony"
        )
    }
)

