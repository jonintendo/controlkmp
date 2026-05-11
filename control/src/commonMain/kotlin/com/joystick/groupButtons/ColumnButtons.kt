package com.joystick.groupButtons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.joystick.ControlButton
import com.joystick.buttons.PressReleaseButton

@Composable
fun ColumnButton(buttons: List<ControlButton>) {
    val buttonSize = 50.dp
    Column(
        Modifier.height(100.dp).fillMaxWidth().background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        buttons.map { controlButton ->
            PressReleaseButton(
                onPress = controlButton.action,
                modifier = controlButton.modifier,
                description = controlButton.description,
                icon = controlButton.icon,
                onRelease = controlButton.actionRelease
            )
        }
    }
}