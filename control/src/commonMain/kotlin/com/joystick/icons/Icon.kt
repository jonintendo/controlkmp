package com.joystick.icons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddRoad
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Start
import androidx.compose.material.icons.filled.Stop
import androidx.compose.ui.graphics.vector.ImageVector
import com.composables.cancelGoSvgrepoCom
import com.composables.goSvgrepoCom
import com.composables.playCircleSvgrepoCom
import com.composables.setHomeSvgrepoCom
import com.composables.stopCircleSvgrepoCom
import com.composables.thermometerColdBoldSvgrepoCom
import com.composables.thermometerTemperatureSvgrepoCom
import com.composables.wifiOffSvgrepoCom
import com.composables.wifiSvgrepoCom


fun Icons(icon: String): ImageVector {
    var returnIcon = Icons.Default.Camera
    when (icon) {
        "start" -> {
            returnIcon = Icons.Default.Start
        }

        "ir" -> {
            returnIcon = thermometerColdBoldSvgrepoCom
        }

        "play" -> {
            returnIcon = playCircleSvgrepoCom
        }

        "stop" -> {
            returnIcon = stopCircleSvgrepoCom
        }

        "home" -> {
            returnIcon = setHomeSvgrepoCom
        }
        "go" -> {
            returnIcon = goSvgrepoCom
        }
        "cancel go" -> {
            returnIcon = cancelGoSvgrepoCom
        }
        "connect" -> {
            returnIcon = wifiSvgrepoCom
        }

        "disconnect" -> {
            returnIcon = wifiOffSvgrepoCom
        }

    }
    return returnIcon
}