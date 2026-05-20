package com.joystick.groupButtons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.joystick.ControlButton
import com.joystick.buttons.PressReleaseButton

@Composable
fun ColumnButton(
    buttons: List<ControlButton>,
    modifier: Modifier
) {
    BoxWithConstraints(modifier) {
        val buttonSize = maxHeight / buttons.size
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            buttons.map { controlButton ->
                PressReleaseButton(
                    onPress = controlButton.action,
                    modifier = controlButton.modifier.then(Modifier.size(buttonSize)),
                    description = controlButton.description,
                    icon = controlButton.icon,
                    onRelease = controlButton.actionRelease
                )
            }
        }
    }
}