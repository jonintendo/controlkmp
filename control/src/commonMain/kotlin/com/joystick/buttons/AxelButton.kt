package com.joystick.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleDown
import androidx.compose.material.icons.filled.ArrowCircleLeft
import androidx.compose.material.icons.filled.ArrowCircleRight
import androidx.compose.material.icons.filled.ArrowCircleUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.joystick.ControlButton
import com.joystick.Direction


@Composable
fun AxelButton(
    axelButtons: List<ControlButton>,
    size: Dp
) {
    AxelButton(
        axelButtons.first { it.direction == Direction.Up },
        axelButtons.first { it.direction == Direction.Left },
        axelButtons.first { it.direction == Direction.Right },
        axelButtons.first { it.direction == Direction.Down },
        size
    )
}

@Composable
fun AxelButton(
    up: ControlButton,
    left: ControlButton,
    right: ControlButton,
    down: ControlButton,
    size: Dp
) {
    Box(Modifier.size(size)) {
        val buttonSize = 50.dp
        Column(
            Modifier.fillMaxSize(100f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            PressReleaseButton(
                description = up.description,
                onPress = up.action,
                onRelease = up.actionRelease,
                icon = Icons.Default.ArrowCircleUp,
                modifier = up.modifier.size(buttonSize)
            )


            Row(
                Modifier.fillMaxWidth(100f),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                PressReleaseButton(
                    description = left.description,
                    onPress = left.action,
                    onRelease = left.actionRelease,
                    icon = Icons.Default.ArrowCircleLeft,
                    modifier = up.modifier.size(buttonSize)
                )


                PressReleaseButton(
                    description = right.description,
                    onPress = right.action,
                    onRelease = right.actionRelease,
                    icon = Icons.Default.ArrowCircleRight,
                    modifier = up.modifier.size(buttonSize)
                )

            }

            PressReleaseButton(
                description = down.description,
                onPress = down.action,
                onRelease = down.actionRelease,
                icon = Icons.Default.ArrowCircleDown,
                modifier = up.modifier.size(buttonSize)
            )

        }
    }
}
