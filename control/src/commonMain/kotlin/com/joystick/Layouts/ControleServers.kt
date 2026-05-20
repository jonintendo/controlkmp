package com.joystick.layouts

import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joystick.ControlScreen

@Composable
fun ControleServers(views: List<ControlScreen>) {
    var showContent by remember { mutableStateOf(false) }
    var contentt by remember { mutableStateOf(@Composable { Text("") }) }

    Column() {
        LazyVerticalGrid(
            GridCells.Adaptive(300.dp),
            // modifier = Modifier.size(1000.dp),
        ) {
            items(views.size) { i ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .height(300.dp)
                        .combinedClickable(
                            onClick = {
                                contentt = views[i].screen
                                showContent = !showContent
                                println("click")
                            },
                            onDoubleClick = {
                                println("d click")
                            },
                            onLongClick = {
                                println("l click")
                            })
                    // .size(200.dp),
                    //contentAlignment = Alignment.Center,
                ) {
                    Text("window: $i, ${views[0].name} ")
                    views[i].screen()
                }
            }
        }

        if (showContent) {
            contentt()

        }
    }
}