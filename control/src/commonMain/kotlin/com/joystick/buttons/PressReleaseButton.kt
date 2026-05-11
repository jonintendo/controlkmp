package com.joystick.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.jonintendo.control.generated.resources.Res
import com.jonintendo.control.generated.resources.cam
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun PressReleaseButton(
    onPress: () -> Unit,
    onRelease: () -> Unit,
    description: String = "Press and Release Me",
    modifier: Modifier = Modifier,
) {
    PressReleaseButton(onPress, onRelease, null, description, modifier)
}


@Composable
fun PressReleaseButton(
    onPress: () -> Unit,
    onRelease: () -> Unit,
    icon: DrawableResource?,
    description: String = "Press and Release Me",
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }

    // Observe interactions to detect press and release
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> {
                    onPress()
                }

                is PressInteraction.Release -> {
                    onRelease()
                }

                is PressInteraction.Cancel -> {
                    // Handle cases where the press is cancelled (e.g., user drags finger away)
                    onRelease()
                }
            }
        }
    }
    if (icon != null) {
        IconButton(
            onClick = {},
            modifier = modifier.width(50.dp),
            interactionSource = interactionSource
        ) {
//            Icon(
//                icon,
//                contentDescription = description,
//                modifier = Modifier.fillMaxSize()
//            )
            Image(
                painter = painterResource(
                    resource = icon
                ),
                contentDescription = "My Vector Image",
                modifier = Modifier.size(100.dp)
            )

        }
    } else {
        Button(
            onClick = { /* The onClick is still required but can be empty if you only need press/release */ },
            modifier = modifier,
            interactionSource = interactionSource // Pass the interactionSource to the Button
        ) {
            Text(description)
        }
    }
}