package com.joystick.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.jonintendo.control.generated.resources.Res
import com.jonintendo.control.generated.resources.switchback
import com.joystick.ControlButton
import com.joystick.ControlScreen
import com.joystick.buttons.AnalogButton
import com.joystick.buttons.PressReleaseButton
import com.joystick.groupButtons.DPadButtons

import org.jetbrains.compose.resources.painterResource

@Composable
fun ControleSwitch(
    minusButton: ControlButton,
    plusButton: ControlButton,
    squareButton: ControlButton,
    homeButton: ControlButton,
    leftDPadButtons: List<ControlButton>,
    rightDPadButtons: List<ControlButton>,
    leftAnalogButton: ControlButton,
    rightAnalogButtons: ControlButton,
    showMiddleScreen: ControlScreen
) {

    Box(
        modifier = Modifier
            .paint(
                painter = painterResource(Res.drawable.switchback),
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds
            ).aspectRatio(784f / 369f),
        contentAlignment = Alignment.Center
    ) {

        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val wb = maxWidth * 0.06f
            val hb = maxHeight * 0.06f

            val wbdp = wb * 1.5f
            val hbdp = wb * 1.5f

            Box(
                modifier = Modifier
                    .offset(x = maxWidth / 5, y = maxHeight / 10f)
                    .width(
                        maxWidth * 0.59300184f
                    )
                    .height(
                        maxHeight * 0.78494626f
                    )
                    .background(Color.Blue)
            ) {
                showMiddleScreen.screen()

            }

            PressReleaseButton(//minus
                onPress = minusButton.action,
                modifier = minusButton.modifier
                    .offset(x = maxWidth * 0.085f, y = maxHeight * 0.095f)
                    .size(wb, hb),
                description = minusButton.description,
                icon = minusButton.icon,
                onRelease = minusButton.actionRelease
            )


//leftAnalog
            AnalogButton(
                { posx, posy -> leftAnalogButton.action(posx, posy) },
                { posx, posy -> leftAnalogButton.actionRelease(posx, posy) },
                wbdp / 2,
                wbdp,
                Modifier
                    .offset(x = maxWidth * 0.026f, y = maxHeight * 0.23f)
                    .size(wbdp, hbdp),
            )


            if (leftDPadButtons.size >= 4) {//leftDPad
                DPadButtons(
                    leftDPadButtons[0],
                    leftDPadButtons[1],
                    leftDPadButtons[2],
                    leftDPadButtons[3],
                    Modifier
                        .offset(x = maxWidth * 0.026f, y = maxHeight * 0.5f)
                        .size(wbdp, hbdp)
                )
            }

            PressReleaseButton(//square
                onPress = squareButton.action,
                modifier = squareButton.modifier
                    .offset(x = maxWidth * 0.085f, y = maxHeight * 0.83f)
                    .size(wb, hb),
                description = squareButton.description,
                icon = squareButton.icon,
                onRelease = squareButton.actionRelease
            )

            PressReleaseButton(//plus
                onPress = plusButton.action,
                modifier = plusButton.modifier
                    .offset(x = maxWidth * 0.86f, y = maxHeight * 0.095f)
                    .size(wb, hb),
                description = plusButton.description,
                icon = plusButton.icon,
                onRelease = plusButton.actionRelease
            )



            if (rightDPadButtons.size >= 4) {//rightDPad
                DPadButtons(
                    rightDPadButtons[0],
                    rightDPadButtons[1],
                    rightDPadButtons[2],
                    rightDPadButtons[3],
                    Modifier
                        .offset(x = maxWidth * 0.88f, y = maxHeight * 0.23f)
                        .size(wbdp, hbdp)
                )
            }




            AnalogButton(//rightAnalog
                { posx, posy -> rightAnalogButtons.action(posx, posy) },
                { posx, posy -> rightAnalogButtons.action(posx, posy) },
                wbdp / 2,
                wbdp,
                Modifier
                    .offset(x = maxWidth * 0.88f, y = maxHeight * 0.5f)
                    .size(wbdp, hbdp)
            )


            PressReleaseButton(//home
                onPress = homeButton.action,
                modifier = homeButton.modifier
                    .offset(x = maxWidth * 0.86f, y = maxHeight * 0.84f)
                    .size(wb, hb),
                description = homeButton.description,
                icon = homeButton.icon,
                onRelease = homeButton.actionRelease
            )
        }
    }

}