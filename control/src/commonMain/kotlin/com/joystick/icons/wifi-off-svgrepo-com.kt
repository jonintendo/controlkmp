package com.composables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val wifiOffSvgrepoCom: ImageVector
    get() {
        if (_wifiOffSvgrepoCom != null) return _wifiOffSvgrepoCom!!
        
        _wifiOffSvgrepoCom = ImageVector.Builder(
            name = "wifiOffSvgrepoCom",
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
                moveTo(15.57f, 11.3f)
                lineToRelative(0.38f, 0.19f)
                lineToRelative(0.36f, 0.2f)
                lineToRelative(0.36f, 0.22f)
                lineToRelative(0.35f, 0.25f)
                lineToRelative(0.34f, 0.26f)
                curveToRelative(0.11f, 0.09f, 0.22f, 0.18f, 0.32f, 0.28f)
                lineTo(18f, 13f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Miter
            ) {
                moveTo(6f, 13f)
                lineToRelative(0.32f, -0.3f)
                curveToRelative(0.1f, -0.1f, 0.21f, -0.19f, 0.32f, -0.28f)
                lineTo(7f, 12.16f)
                lineToRelative(0.35f, -0.25f)
                lineToRelative(0.36f, -0.22f)
                lineToRelative(0.36f, -0.2f)
                lineToRelative(0.38f, -0.19f)
                lineToRelative(0.38f, -0.16f)
                curveToRelative(0.12f, -0.06f, 0.25f, -0.1f, 0.38f, -0.15f)
                lineToRelative(0.39f, -0.13f)
                lineToRelative(0.4f, -0.1f)
                lineToRelative(0.4f, -0.09f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Miter
            ) {
                moveTo(12f, 6f)
                arcToRelative(13f, 13f, 0f, false, true, 2.48f, 0.24f)
                arcTo(12.8f, 12.8f, 0f, false, true, 16.89f, 7f)
                arcToRelative(13.56f, 13.56f, 0f, false, true, 2.26f, 1.19f)
                arcToRelative(12.85f, 12.85f, 0f, false, true, 2f, 1.67f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Miter
            ) {
                moveTo(2.81f, 9.81f)
                lineToRelative(0.24f, -0.24f)
                lineToRelative(0.24f, -0.22f)
                lineToRelative(0.25f, -0.22f)
                lineToRelative(0.25f, -0.21f)
                lineToRelative(0.26f, -0.21f)
                lineToRelative(0.26f, -0.2f)
                lineToRelative(0.27f, -0.19f)
                lineToRelative(0.27f, -0.18f)
                lineTo(5.12f, 8f)
                lineToRelative(0.27f, -0.17f)
                lineToRelative(0.28f, -0.16f)
                lineTo(6f, 7.49f)
                lineToRelative(0.29f, -0.15f)
                lineToRelative(0.29f, -0.14f)
                lineToRelative(0.29f, -0.13f)
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
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Miter
            ) {
                moveTo(2f, 2f)
                lineTo(22f, 22f)
            }
        }.build()
        
        return _wifiOffSvgrepoCom!!
    }

private var _wifiOffSvgrepoCom: ImageVector? = null

