package com.joystick

import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter

@Composable
fun MiddleScreenCamView(
    frameFlow: MutableStateFlow<String>,
    GimballYawAdd: () -> Unit,
    GimballYawDrop: () -> Unit,
    GimballPitchAdd: () -> Unit,
    GimballPitchDrop: () -> Unit,
    GimballRollAdd: () -> Unit,
    GimballRollDrop: () -> Unit,
    GimballReset: () -> Unit,
) {
    val frameState by frameFlow.collectAsState()

    var number by remember { mutableFloatStateOf(0f) }
    var yy by remember { mutableFloatStateOf(0f) }
    var xx by remember { mutableFloatStateOf(0f) }
    var count by remember { mutableLongStateOf(0) }
    var text by remember { mutableStateOf("Click magenta box!") }
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .pointerInput(Unit) {
//                detectTransformGestures { _, pan, zoom, _ ->
//                    println("Pointer Panx: ${pan.x}, pany:${pan.y} , zoom:$zoom")
//                }
                awaitPointerEventScope {
                    while (true) {
                        val event = awaitPointerEvent()
                        // Handle raw event (e.g., event.type == PointerEventType.Move)
                        // println("Pointer Event: ${event.type}")
                        when (event.type) {

                            PointerEventType.Scroll -> {
                                number += event.changes.first().scrollDelta.y
                            }

                            PointerEventType.Move -> {
                                yy = event.changes.first().position.y
                                xx = event.changes.first().position.x
                            }

                            PointerEventType.Press -> {
                                // number2 = event.changes.first().id.value
                                println(event.changes.first())
                            }
                        }
                    }
                }

            }.combinedClickable(
                onClick = {
                    text = "Click! ${count++}"
                    GimballYawDrop()
                },
                onDoubleClick = {
                    text = "Double click! ${count++}"
                },
                onLongClick = {
                    text = "Long click! ${count++}"
                    GimballReset()
                }
            )
    ) {

        Column() {
            // repeat(100) {
            Text("Item $number", Modifier.padding(16.dp))
            Text("Item $xx", Modifier.padding(16.dp))
            Text("Item $yy", Modifier.padding(16.dp))
            Text("Item $text", Modifier.padding(16.dp))
            // }

            val painter = rememberAsyncImagePainter("")
            var myPainter by remember { mutableStateOf(painter as Painter) }
            AsyncImage(
                model = "data:image/jpeg;base64,$frameState",
                contentDescription = null,
                modifier = Modifier.size(300.dp, 200.dp),
                onSuccess = { successState: AsyncImagePainter.State.Success ->
                    // Image loaded successfully, you can access the drawable here
                    myPainter = successState.painter
                },
                placeholder = myPainter,
            )

        }

    }
}