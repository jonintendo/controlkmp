package com.joystick.groupButtons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
fun RowButton(buttons: List<ControlButton>) {
    val buttonSize = 50.dp
    Row(
        Modifier.height(50.dp).fillMaxWidth().background(Color.Yellow),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
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