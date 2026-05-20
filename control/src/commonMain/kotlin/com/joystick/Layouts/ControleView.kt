package com.joystick.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.util.fastMap
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
    //sideColumnsWidth: Dp = 150.dp,
    columnsButtonsWidth: Dp = 100.dp,
    rowButtonsHeight: Dp = 50.dp,
    backgroundButtonsColor: Color = Color.Transparent,
    backgroundBoxColor: Color = Color.Transparent
) {

    var showMiddleScreen by remember { mutableStateOf("") }
    var splitMiddleScreen by remember { mutableStateOf(false) }

    val screenButtons = mutableListOf(
        ControlButton(
            action = { f, t ->
                splitMiddleScreen = !splitMiddleScreen
                println("split")
            },
            icon = Res.drawable.split,
           // modifier = Modifier.size(rowButtonsHeight)
        )
    )

    screenButtons.addAll(middleScreen.mapIndexed { index, controlScreen ->
        ControlButton(
            action = { f, t ->
                splitMiddleScreen = false
                showMiddleScreen = controlScreen.name
            },
            icon = controlScreen.icon,
          //  modifier = Modifier.size(rowButtonsHeight)
        )
    })


    BoxWithConstraints(
        // Modifier.size(800.dp),
        Modifier
            .fillMaxSize()
            .safeDrawingPadding(),
        contentAlignment = Alignment.Center
    ) {
        val sidesWith = maxWidth * 0.1f
        val middleWith = maxWidth * 0.8f
        val edgesHeight = maxHeight * 0.3f
        val middleHeight = maxHeight * 0.4f

        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                Modifier
                    .width(sidesWith)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                ColumnButton(
                    topLeftButtons,
                    Modifier
                        .width(columnsButtonsWidth)
                        .height(edgesHeight)
                        .background(backgroundButtonsColor)
                )
                if (leftDPadButtons.size >= 4) {
                    DPadButtons(
                        leftDPadButtons[0],
                        leftDPadButtons[1],
                        leftDPadButtons[2],
                        leftDPadButtons[3],
                        Modifier
                            .size(sidesWith)
                            .background(backgroundButtonsColor)
                    )
                }
                ColumnButton(
                    bottomLeftButtons,
                    Modifier
                        .width(columnsButtonsWidth)
                        .height(edgesHeight)
                        .background(backgroundButtonsColor)
                )
            }

            Column(
                Modifier
                    .width(middleWith),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.9f)
                        .fillMaxWidth()
                        .background(backgroundBoxColor)
                    //modifier = Modifier.fillMaxWidth().background(Color.Red)
                ) {
                    if (splitMiddleScreen) {
                        LazyVerticalGrid(
                            GridCells.Adaptive(300.dp),
                            //GridCells.Fixed(2)
                        )
                        {
                            items(middleScreen.size) { i ->
                                middleScreen[i].screen()
                            }
                        }


                    } else {
                        middleScreen.firstOrNull { it.name == showMiddleScreen }?.screen()
                    }
                }

                RowButton(
                    middleScreenBottomButtons,
                    Modifier
                        .height(rowButtonsHeight)
                        .fillMaxWidth()
                        .background(backgroundButtonsColor)
                )

            }

            Column(
                Modifier
                    .width(sidesWith)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    Modifier
                        .height(edgesHeight)
                        .fillMaxWidth(),
                    Arrangement.SpaceBetween
                ) {
                    topRightButtons.map { buttons ->
                        RowButton(
                            buttons,
                            Modifier
                                .height(rowButtonsHeight)
                                .fillMaxWidth()
                                .background(backgroundButtonsColor)
                        )
                    }
                }

                if (rightDPadButtons.size >= 4) {
                    DPadButtons(
                        rightDPadButtons[0],
                        rightDPadButtons[1],
                        rightDPadButtons[2],
                        rightDPadButtons[3],
                        Modifier
                            .size(sidesWith)
                            .background(backgroundButtonsColor)
                    )
                }
                Column(
                    Modifier
                        .height(edgesHeight)
                        .fillMaxWidth(),
                    Arrangement.SpaceBetween
                ) {
                    RowButton(
                        bottomRightButtons,
                        Modifier
                            .height(rowButtonsHeight)
                            .fillMaxWidth()
                            .background(backgroundButtonsColor)
                    )
                    RowButton(
                        screenButtons,
                        Modifier
                            .height(rowButtonsHeight)
                            .fillMaxWidth()
                            .background(backgroundButtonsColor)
                    )
                }
            }
        }


    }
}