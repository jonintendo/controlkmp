package com.composables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val playCircleSvgrepoCom: ImageVector
    get() {
        if (_playCircleSvgrepoCom != null) return _playCircleSvgrepoCom!!
        
        _playCircleSvgrepoCom = ImageVector.Builder(
            name = "playCircleSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF1C274C)),
                strokeLineWidth = 1.5f
            ) {
                moveTo(22f, 12f)
                arcTo(10f, 10f, 0f, false, true, 12f, 22f)
                arcTo(10f, 10f, 0f, false, true, 2f, 12f)
                arcTo(10f, 10f, 0f, false, true, 22f, 12f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF1C274C)),
                strokeLineWidth = 1.5f
            ) {
                moveTo(13.8876f, 9.9348f)
                curveTo(14.9625f, 10.8117f, 15.5f, 11.2501f, 15.5f, 12f)
                curveTo(15.5f, 12.7499f, 14.9625f, 13.1883f, 13.8876f, 14.0652f)
                curveTo(13.5909f, 14.3073f, 13.2966f, 14.5352f, 13.0261f, 14.7251f)
                curveTo(12.7888f, 14.8917f, 12.5201f, 15.064f, 12.2419f, 15.2332f)
                curveTo(11.1695f, 15.8853f, 10.6333f, 16.2114f, 10.1524f, 15.8504f)
                curveTo(9.6715f, 15.4894f, 9.62779f, 14.7336f, 9.54038f, 13.2222f)
                curveTo(9.51566f, 12.7947f, 9.5f, 12.3757f, 9.5f, 12f)
                curveTo(9.5f, 11.6243f, 9.51566f, 11.2053f, 9.54038f, 10.7778f)
                curveTo(9.62779f, 9.26636f, 9.6715f, 8.51061f, 10.1524f, 8.1496f)
                curveTo(10.6333f, 7.78859f, 11.1695f, 8.11466f, 12.2419f, 8.76679f)
                curveTo(12.5201f, 8.93597f, 12.7888f, 9.10831f, 13.0261f, 9.27492f)
                curveTo(13.2966f, 9.46483f, 13.5909f, 9.69274f, 13.8876f, 9.9348f)
                close()
            }
        }.build()
        
        return _playCircleSvgrepoCom!!
    }

private var _playCircleSvgrepoCom: ImageVector? = null

