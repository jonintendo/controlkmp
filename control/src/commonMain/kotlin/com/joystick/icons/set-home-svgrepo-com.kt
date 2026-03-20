package com.composables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val setHomeSvgrepoCom: ImageVector
    get() {
        if (_setHomeSvgrepoCom != null) return _setHomeSvgrepoCom!!
        
        _setHomeSvgrepoCom = ImageVector.Builder(
            name = "setHomeSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF2e3436))
            ) {
                moveToRelative(8f, 1f)
                curveToRelative(-0.207031f, 0f, -0.410156f, 0.066406f, -0.578125f, 0.1875f)
                lineToRelative(-7f, 5f)
                curveToRelative(-0.453125f, 0.320312f, -0.554687f, 0.941406f, -0.234375f, 1.394531f)
                curveToRelative(0.1875f, 0.261719f, 0.488281f, 0.417969f, 0.8125f, 0.417969f)
                verticalLineToRelative(4f)
                curveToRelative(0f, 1.644531f, 1.355469f, 3f, 3f, 3f)
                horizontalLineToRelative(8f)
                curveToRelative(1.644531f, 0f, 3f, -1.320312f, 3f, -3f)
                verticalLineToRelative(-4f)
                curveToRelative(0.324219f, 0f, 0.625f, -0.15625f, 0.816406f, -0.417969f)
                curveToRelative(0.320313f, -0.453125f, 0.214844f, -1.074219f, -0.234375f, -1.394531f)
                lineToRelative(-7f, -5f)
                curveToRelative(-0.167969f, -0.121094f, -0.375f, -0.1875f, -0.582031f, -0.1875f)
                close()
                moveToRelative(0f, 2.230469f)
                lineToRelative(5f, 3.570312f)
                verticalLineToRelative(5.199219f)
                curveToRelative(0f, 0.5625f, -0.4375f, 1f, -1f, 1f)
                horizontalLineToRelative(-3f)
                verticalLineToRelative(-4f)
                curveToRelative(0f, -0.554688f, -0.445312f, -1f, -1f, -1f)
                horizontalLineToRelative(-1f)
                curveToRelative(-0.554688f, 0f, -1f, 0.445312f, -1f, 1f)
                verticalLineToRelative(4f)
                horizontalLineToRelative(-2f)
                curveToRelative(-0.5625f, 0f, -1f, -0.4375f, -1f, -1f)
                verticalLineToRelative(-5.199219f)
                close()
                moveToRelative(0f, 0f)
            }
        }.build()
        
        return _setHomeSvgrepoCom!!
    }

private var _setHomeSvgrepoCom: ImageVector? = null

