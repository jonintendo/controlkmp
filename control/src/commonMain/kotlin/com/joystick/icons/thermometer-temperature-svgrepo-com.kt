package com.composables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val thermometerTemperatureSvgrepoCom: ImageVector
    get() {
        if (_thermometerTemperatureSvgrepoCom != null) return _thermometerTemperatureSvgrepoCom!!
        
        _thermometerTemperatureSvgrepoCom = ImageVector.Builder(
            name = "thermometerTemperatureSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 501.333f,
            viewportHeight = 501.333f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFF000000))
                ) {
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFF000000))
                ) {
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFF000000))
                ) {
                }
            }
        }.build()
        
        return _thermometerTemperatureSvgrepoCom!!
    }

private var _thermometerTemperatureSvgrepoCom: ImageVector? = null

