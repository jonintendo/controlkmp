package com.joystick.groupButtons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowCircleDown
//import androidx.compose.material.icons.filled.ArrowCircleLeft
//import androidx.compose.material.icons.filled.ArrowCircleRight
//import androidx.compose.material.icons.filled.ArrowCircleUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jonintendo.control.generated.resources.Res
import com.jonintendo.control.generated.resources.down
import com.jonintendo.control.generated.resources.left
import com.jonintendo.control.generated.resources.right
import com.jonintendo.control.generated.resources.up
import com.joystick.ControlButton
import com.joystick.buttons.PressReleaseButton


@Composable
fun DPadButtons(
    up: ControlButton,
    left: ControlButton,
    right: ControlButton,
    down: ControlButton,
    modifier: Modifier
) {
    BoxWithConstraints(
        modifier,
        Alignment.Center
    ) {
        val wb = maxWidth / 3
        val hb = maxHeight / 3

        Column(
            Modifier.fillMaxSize(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {


            PressReleaseButton(
                description = up.description,
                onPress = up.action,
                onRelease = up.actionRelease,
                icon = up.icon,
                modifier = up.modifier.size(wb, hb)
            )


            Row(
                Modifier.fillMaxWidth(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                PressReleaseButton(
                    description = left.description,
                    onPress = left.action,
                    onRelease = left.actionRelease,
                    icon = left.icon,
                    modifier = left.modifier.size(wb, hb)
                )


                PressReleaseButton(
                    description = right.description,
                    onPress = right.action,
                    onRelease = right.actionRelease,
                    icon = right.icon,
                    modifier = right.modifier.size(wb, hb)
                )

            }

            PressReleaseButton(
                description = down.description,
                onPress = down.action,
                onRelease = down.actionRelease,
                icon = down.icon,
                modifier = down.modifier.size(wb, hb)
            )

        }
    }
}
