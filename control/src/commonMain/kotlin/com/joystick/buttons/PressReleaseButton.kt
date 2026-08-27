package com.joystick.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.jonintendo.control.generated.resources.Res
import com.jonintendo.control.generated.resources.cam
import com.jonintendo.control.generated.resources.empty
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun PressReleaseButton(
    onPress: () -> Unit,
    onRelease: () -> Unit,
    description: String,
    modifier: Modifier = Modifier,
) {
    PressReleaseButton({t,u->onPress()}, {t,u->onRelease()}, null, description, modifier)
}

@Composable
fun PressReleaseButton(
    onPress: () -> Unit,
    onRelease: () -> Unit,
    icon: DrawableResource,
    modifier: Modifier = Modifier,
) {
    PressReleaseButton({t,u->onPress()}, {t,u->onRelease()}, icon, null, modifier)
}


@Composable
fun PressReleaseButton(
    onPress: () -> Unit,
    description: String,
    modifier: Modifier = Modifier,
) {
    PressReleaseButton({t,u->onPress()}, {t,u->}, null, description, modifier)
}
@Composable
fun PressReleaseButton(
    onPress: () -> Unit,
    icon: DrawableResource,
    modifier: Modifier = Modifier,
) {
    PressReleaseButton({t,u->onPress()}, {t,u->}, icon, null, modifier)
}


@Composable
fun PressReleaseButton(
    onPress: (posX: Float , posY: Float) -> Unit,
    onRelease: (posX: Float, posY: Float) -> Unit,
    icon: DrawableResource?,
    description: String?,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }

    // Observe interactions to detect press and release
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> {
                    onPress(0.0f,0.0f)
                }

                is PressInteraction.Release -> {
                    onRelease(0.0f,0.0f)
                }

                is PressInteraction.Cancel -> {
                    // Handle cases where the press is cancelled (e.g., user drags finger away)
                    onRelease(0.0f,0.0f)
                }
            }
        }
    }


    if (icon != null) {
        IconButton(
            onClick = {},
            modifier = modifier,
            interactionSource = interactionSource
        ) {
            Image(
                painter = painterResource(
                    resource = icon
                ),
                contentDescription = description,
                modifier = Modifier.fillMaxSize()
            )

        }
    } else {
        if (description != null) {
            Button(
                onClick = { /* The onClick is still required but can be empty if you only need press/release */ },
                modifier = modifier,
                interactionSource = interactionSource, // Pass the interactionSource to the Button
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF2E7D32), // Custom green background
                    contentColor = Color.White,          // White text color
                    disabledBackgroundColor = Color.Gray, // Color when button is disabled
                    disabledContentColor = Color.LightGray
                )
            ) {
                Text(description)
            }
        } else {
            IconButton(
                onClick = {},
                modifier = modifier,
                interactionSource = interactionSource
            ) {
                Image(
                    painter = painterResource(
                        resource = Res.drawable.empty
                    ),
                    contentDescription = "My Vector Image",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}