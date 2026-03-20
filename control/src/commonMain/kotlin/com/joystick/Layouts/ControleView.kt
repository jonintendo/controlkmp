package com.joystick.Layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Map

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
import com.joystick.buttons.AxelButton
import com.joystick.buttons.ColumnButton
import com.joystick.buttons.RowButton


@Composable
fun ControleView(
    topLeftButtons: List<ControlButton>,
    bottomLeftButtons: List<ControlButton>,
    topRightButtons: MutableList<List<ControlButton>>,
    bottomRightButtons: List<ControlButton>,
    leftAxisButtons: List<ControlButton>,
    rightAxisButtons: List<ControlButton>,
    middleScreen: List<@Composable () -> Unit>,
    middleScreenBottomButtons: List<ControlButton>,
) {


    val sideColumnsWidth = 150.dp


    var showMiddleScreen by remember { mutableStateOf(0) }
    var splitMiddleScreen by remember { mutableStateOf(false) }

    val screenButtons = listOf(
        ControlButton(
            action = {
                splitMiddleScreen = false
                showMiddleScreen = 1
                println("Map")
            },
            icon = Icons.Default.Map
        ),
        ControlButton(
            action = {
                splitMiddleScreen = false
                showMiddleScreen = 0
                println("camera")
            },
            icon = Icons.Default.Camera
        ),
        ControlButton(
            action = {
                splitMiddleScreen = false
                showMiddleScreen = 2
                println("camera")
            },
            icon = Icons.Default.Camera
        ),


//        ControlButton(
//            action = {
//                splitMiddleScreen = !splitMiddleScreen
//                println("split")
//            },
//            icon = Icons.Default.Splitscreen
//        )

    )


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
                AxelButton(leftAxisButtons, sideColumnsWidth)
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
                                items(4) { i ->
                                    if (i == 0)
                                        middleScreen[i]()

                                    if (i == 3)
                                        middleScreen[i - 2]()
                                }
                            },
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        middleScreen[showMiddleScreen]()
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
                AxelButton(rightAxisButtons, sideColumnsWidth)
                RowButton(bottomRightButtons)
                RowButton(screenButtons)
            }
        }


    }
}