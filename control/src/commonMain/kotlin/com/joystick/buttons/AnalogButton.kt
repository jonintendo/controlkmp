package com.joystick.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import com.jonintendo.control.generated.resources.Res
import com.jonintendo.control.generated.resources.empty
import org.jetbrains.compose.resources.painterResource
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sin
import kotlin.math.sqrt

@Composable
fun AnalogButton(
    onPress: (posX: Float, posY: Float) -> Unit,
    onRelease: (posX: Float, posY: Float) -> Unit,
    dotSize: Dp, size: Dp,
    modifier: Modifier = Modifier,
) {

    val localDensity = LocalDensity.current
    val centerX = with(localDensity) { ((size - dotSize) / 2).toPx() }
    val centerY = with(localDensity) { ((size - dotSize) / 2).toPx() }

    var navState by remember { mutableStateOf(NavState.PRESSED) }
    var navKey by remember { mutableStateOf(NavKey.UNKNOWN) }

    var offsetX by remember { mutableStateOf(centerX) }
    var offsetY by remember { mutableStateOf(centerY) }
    var radius by remember { mutableStateOf(0f) }
    var theta by remember { mutableStateOf(0f) }
    var positionX by remember { mutableStateOf(0f) }
    var positionY by remember { mutableStateOf(0f) }


    fun onValueChanged(key: NavKey, state: NavState, posX: Float, posY: Float) {
        println("key: ${key.name} state: ${state.name} ")
        when (state) {
            NavState.PRESSED -> onPress(posX, posY)
            NavState.RELEASED -> onRelease(posX, posY)
        }
    }

    Box(
        modifier
        // .size(size)
        // .background(Color.Blue)
    ) {
        Box(
            modifier = Modifier
                .paint(
                    painterResource(Res.drawable.empty),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Inside
                )
        ) {
            Image(
                painter = painterResource(Res.drawable.empty),
                contentDescription = "jj",
                modifier = Modifier
                    .offset {
                        IntOffset(
                            (positionX + centerX).roundToInt(),
                            (positionY + centerY).roundToInt()
                        )
                    }
                    .size(dotSize)
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragStart = {
                                navState = NavState.PRESSED
                            },

                            onDragEnd = {
                                offsetX = centerX
                                offsetY = centerY
                                radius = 0f
                                theta = 0f
                                positionX = 0f
                                positionY = 0f

                                navState = NavState.RELEASED
                                if (navKey != NavKey.UNKNOWN) {
                                    //releaseAllNavKeys()
                                    navKey = NavKey.UNKNOWN
                                }
                                onValueChanged(navKey, NavState.RELEASED, positionX, positionY)
                            },

                            onDrag = { pointerInputChange: PointerInputChange, offset: Offset ->

                                if (navState != NavState.PRESSED) {
                                    return@detectDragGestures
                                }

                                pointerInputChange.consume()

                                val x = offsetX + offset.x - centerX
                                val y = offsetY + offset.y - centerY

                                cartesianToPolar(x, y).apply {
                                    theta = first
                                    radius = second
                                }

                                offsetX += offset.x
                                offsetY += offset.y


                                val maxRadius = with(localDensity) { (size / 2).toPx() }
                                if (radius > maxRadius) {
                                    polarToCartesian(maxRadius, theta)
                                } else {
                                    polarToCartesian(radius, theta)
                                }.apply {
                                    positionX = first
                                    positionY = second
                                }

                                val fourDimensionDirection = getFourDimensionFromAngle(theta)
                                println(radius)
                                if (navKey != fourDimensionDirection) {


                                    if (navKey != NavKey.UNKNOWN) {
                                        onValueChanged(
                                            navKey,
                                            NavState.RELEASED,
                                            positionX,
                                            positionY
                                        )
                                    }

                                    navKey = fourDimensionDirection

                                    if (navKey != NavKey.UNKNOWN) {
                                        onValueChanged(
                                            navKey,
                                            NavState.PRESSED,
                                            positionX,
                                            positionY
                                        )
                                    }
                                }

                            }
                        )

                    }
            )
        }
    }

}


enum class NavState {
    PRESSED,
    RELEASED
}

enum class NavKey(val theta: Double?) {
    UNKNOWN(null),
    RIGHT(0.0),
    RIGHT_DOWN(PI / 4),
    DOWN(PI / 2),
    LEFT_DOWN(2 * PI / 3),
    LEFT(PI),
    LEFT_UP(-2 * PI / 3),
    UP(-PI / 2),
    RIGHT_UP(-PI / 4)
}


fun polarToCartesian(
    radius: Float,
    theta: Float
): Pair<Float, Float> = Pair(radius * cos(theta), radius * sin(theta))


fun cartesianToPolar(
    x: Float, y: Float
): Pair<Float, Float> =
    Pair(atan2(y.toDouble(), x.toDouble()).toFloat(), sqrt(x.pow(2) + y.pow(2)))

fun getFourDimensionFromAngle(theta: Float): NavKey {
    return NavKey.entries.firstOrNull() { it -> it.theta != null && (theta >= (it.theta - PI / (NavKey.entries.size - 1)) && theta <= (it.theta + PI / (NavKey.entries.size - 1))) }
        ?: NavKey.UNKNOWN
}