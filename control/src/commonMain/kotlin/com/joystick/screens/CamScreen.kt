package com.joystick.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import kotlinx.coroutines.flow.MutableStateFlow
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter

@Composable
fun CamScreen(
    modifier: Modifier,
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

    var yy by remember { mutableFloatStateOf(0f) }
    var xx by remember { mutableFloatStateOf(0f) }

    var zoom by remember { mutableFloatStateOf(0f) }

    var rotation by remember { mutableFloatStateOf(0f) }


    var count by remember { mutableLongStateOf(0) }
    var text by remember { mutableStateOf("Click magenta box!") }

    Box(
        modifier
            .fillMaxSize()
           // .background(Color.Blue)
            .pointerInput(Unit) {
//                detectTransformGestures { _, pan, zoom, _ ->
//                    println("Pointer Panx: ${pan.x}, pany:${pan.y} , zoom:$zoom")
//                }
                awaitEachGesture {
                    //   awaitPointerEventScope {                    while (true) {


                    val event = awaitPointerEvent()
                    val inputChange = event.changes.first()


                    //  if (inputChange.type == PointerType.Mouse) {

                    when (event.type) {
                        PointerEventType.Scroll -> {
                            zoom += inputChange.scrollDelta.y
                        }

                        PointerEventType.Move -> {
                            if (inputChange.pressed) {
                                println(event)
                                if ((inputChange.previousPosition.y - inputChange.position.y) > 0)
                                    yy += 1

                                if ((inputChange.previousPosition.y - inputChange.position.y) < 0)
                                    yy -= 1

                                if ((inputChange.previousPosition.x - inputChange.position.x) > 0)
                                    xx += 1

                                if ((inputChange.previousPosition.x - inputChange.position.x) < 0)
                                    xx -= 1
                            }
                        }

                        PointerEventType.Press -> {
                            //inputChange.consume()
                            println(inputChange)

                        }

                        PointerEventType.Release -> {

                        }

                    }


                    //}
                }

            }.combinedClickable(
                onClick = {
                    text = "Click! ${count++}"
                },
                onDoubleClick = {
                    text = "Double click! ${count++}"
                },
                onLongClick = {
                    text = "Long click! ${count++}"
                }
            ).transformable(
                lockRotationOnZoomPan = true,
                state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->

                    if (zoomChange > 1)
                        zoom += zoomChange
                    if (zoomChange < 1)
                        zoom -= zoomChange


                    //if (zoomChange == 1.toFloat())
                    rotation += rotationChange


                    if (zoomChange == 1.toFloat() && rotationChange == 0.toFloat()) {
                        yy += offsetChange.y * 0.5f
                        xx += offsetChange.x * 0.5f

                    }
                })

    ) {

//        Column() {
//            // repeat(100) {
//            Text("Item $number", Modifier.padding(16.dp))
//            Text("Item $xx", Modifier.padding(16.dp))
//            Text("Item $yy", Modifier.padding(16.dp))
//            Text("Item $text", Modifier.padding(16.dp))
//            // }

            val painter = rememberAsyncImagePainter("")
            var myPainter by remember { mutableStateOf(painter as Painter) }
            AsyncImage(
                model = "data:image/jpeg;base64,$frameState",
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                onSuccess = { successState: AsyncImagePainter.State.Success ->
                    // Image loaded successfully, you can access the drawable here
                    myPainter = successState.painter
                },
                placeholder = myPainter,
            )

      //  }

    }
}