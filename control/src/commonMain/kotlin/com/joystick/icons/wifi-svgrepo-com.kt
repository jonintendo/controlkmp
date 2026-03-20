package com.composables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val wifiSvgrepoCom: ImageVector
    get() {
        if (_wifiSvgrepoCom != null) return _wifiSvgrepoCom!!
        
        _wifiSvgrepoCom = ImageVector.Builder(
            name = "wifiSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Miter
            ) {
                moveTo(11.99f, 19f)
                lineTo(12f, 19f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Miter
            ) {
                moveTo(6f, 13f)
                arcToRelative(8.49f, 8.49f, 0f, false, true, 12f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Miter
            ) {
                moveTo(2.81f, 9.81f)
                arcToRelative(13f, 13f, 0f, false, true, 18.38f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Miter
            ) {
                moveTo(9.17f, 16.17f)
                arcToRelative(4f, 4f, 0f, false, true, 5.66f, 0f)
            }
        }.build()
        
        return _wifiSvgrepoCom!!
    }

private var _wifiSvgrepoCom: ImageVector? = null

