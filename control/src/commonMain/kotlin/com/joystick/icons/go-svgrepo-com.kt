package com.composables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val goSvgrepoCom: ImageVector
    get() {
        if (_goSvgrepoCom != null) return _goSvgrepoCom!!
        
        _goSvgrepoCom = ImageVector.Builder(
            name = "goSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
            }
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(27.728f, 16.024f)
                lineToRelative(-8.485f, 8.482f)
                lineToRelative(-2.828f, -2.835f)
                lineToRelative(3.656f, -3.671f)
                horizontalLineToRelative(-14.071f)
                verticalLineToRelative(-4f)
                horizontalLineToRelative(14.071f)
                lineToRelative(-3.657f, -3.644f)
                lineToRelative(2.828f, -2.816f)
                lineToRelative(8.486f, 8.484f)
                close()
            }
        }.build()
        
        return _goSvgrepoCom!!
    }

private var _goSvgrepoCom: ImageVector? = null

