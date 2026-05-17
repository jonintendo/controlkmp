package com.joystick.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.joystick.ControlButton
import com.joystick.ControlScreen

import com.joystick.groupButtons.DPadButtons
import com.joystick.groupButtons.ColumnButton
import com.joystick.groupButtons.RowButton
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import com.jonintendo.control.generated.resources.Res
import com.jonintendo.control.generated.resources.split

@Composable
fun ControleView(
    topLeftButtons: List<ControlButton>,
    bottomLeftButtons: List<ControlButton>,
    topRightButtons: MutableList<List<ControlButton>>,
    bottomRightButtons: List<ControlButton>,
    leftDPadButtons: List<ControlButton>,
    rightDPadButtons: List<ControlButton>,
    middleScreen: List<ControlScreen>,
    middleScreenBottomButtons: List<ControlButton>,
) {


    val sideColumnsWidth = 150.dp


    var showMiddleScreen by remember { mutableStateOf("") }
    var splitMiddleScreen by remember { mutableStateOf(false) }


    val screenButtons = mutableListOf(
        ControlButton(
            action = { f, t ->
                splitMiddleScreen = !splitMiddleScreen
                println("split")
            },
            icon = Res.drawable.split
        )
    )

    screenButtons.addAll(middleScreen.mapIndexed { index, controlScreen ->
        ControlButton(
            action = { f, t ->
                splitMiddleScreen = false
                showMiddleScreen = controlScreen.name

            },
            icon = controlScreen.icon
        )
    })


    Box(
        // Modifier.size(800.dp),
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            Column(
                Modifier.width(sideColumnsWidth).fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                ColumnButton(topLeftButtons)
                if (leftDPadButtons.size >= 4) {
                    DPadButtons(
                        leftDPadButtons[0],
                        leftDPadButtons[1],
                        leftDPadButtons[2],
                        leftDPadButtons[3],
                        Modifier.size(sideColumnsWidth)
                    )
                }
                ColumnButton(bottomLeftButtons)
            }

            Column(
                Modifier.fillMaxWidth(0.7f).background(color = Color.Green),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier.fillMaxHeight(0.9f).fillMaxWidth().background(Color.Red)
                    //modifier = Modifier.fillMaxWidth().background(Color.Red)
                ) {
                    if (splitMiddleScreen) {
                        LazyVerticalGrid(
                            GridCells.Fixed(2),
                            content = {
                                items(middleScreen.size) { i ->
                                    middleScreen[i].screen()
                                }
                            },
                            modifier = Modifier.fillMaxSize()
                        )

                    } else {
                        middleScreen.firstOrNull { it.name == showMiddleScreen }?.screen()
                    }
                }
                RowButton(middleScreenBottomButtons)

            }

            Column(
                Modifier.width(sideColumnsWidth).fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                topRightButtons.map { buttons ->
                    RowButton(buttons)
                }
                if (rightDPadButtons.size >= 4) {
                    DPadButtons(
                        rightDPadButtons[0],
                        rightDPadButtons[1],
                        rightDPadButtons[2],
                        rightDPadButtons[3],
                        Modifier.size(sideColumnsWidth)
                    )
                }
                RowButton(bottomRightButtons)
                RowButton(screenButtons)
            }
        }


    }
}