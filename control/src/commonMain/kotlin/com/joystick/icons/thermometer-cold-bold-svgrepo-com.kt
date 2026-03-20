package com.composables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val thermometerColdBoldSvgrepoCom: ImageVector
    get() {
        if (_thermometerColdBoldSvgrepoCom != null) return _thermometerColdBoldSvgrepoCom!!
        
        _thermometerColdBoldSvgrepoCom = ImageVector.Builder(
            name = "thermometerColdBoldSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 256f,
            viewportHeight = 256f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(132f, 188f)
                arcToRelative(24f, 24f, 0f, true, true, -36f, -20.771f)
                verticalLineTo(120f)
                arcToRelative(12f, 12f, 0f, false, true, 24f, 0f)
                verticalLineToRelative(47.229f)
                arcTo(24.00875f, 24.00875f, 0f, false, true, 132f, 188f)
                close()
                moveTo(253.84619f, 66.40332f)
                arcToRelative(12.00573f, 12.00573f, 0f, false, false, -15.12109f, -7.70508f)
                lineTo(224f, 63.48291f)
                verticalLineTo(48f)
                arcToRelative(12f, 12f, 0f, false, false, -24f, 0f)
                verticalLineTo(63.48291f)
                lineToRelative(-14.7251f, -4.78467f)
                arcToRelative(12.00048f, 12.00048f, 0f, false, false, -7.417f, 22.82617f)
                lineToRelative(14.72546f, 4.78467f)
                lineTo(183.48291f, 98.835f)
                arcToRelative(12f, 12f, 0f, true, false, 19.416f, 14.10742f)
                lineTo(212f, 100.41553f)
                lineToRelative(9.10107f, 12.52685f)
                arcToRelative(12f, 12f, 0f, false, false, 19.416f, -14.10742f)
                lineToRelative(-9.10046f, -12.52588f)
                lineToRelative(14.72546f, -4.78467f)
                arcTo(12.00086f, 12.00086f, 0f, false, false, 253.84619f, 66.40332f)
                close()
                moveTo(160f, 150.68945f)
                arcToRelative(63.9993f, 63.9993f, 0f, true, true, -104f, -0.00195f)
                verticalLineTo(56f)
                arcToRelative(52f, 52f, 0f, false, true, 104f, 0f)
                close()
                moveTo(148f, 188f)
                arcToRelative(40.03963f, 40.03963f, 0f, false, false, -9.22559f, -25.55371f)
                arcToRelative(12.00187f, 12.00187f, 0f, false, true, -2.77295f, -7.67285f)
                lineTo(136f, 56f)
                arcToRelative(28f, 28f, 0f, false, false, -56f, 0f)
                verticalLineToRelative(98.77539f)
                arcToRelative(12.00265f, 12.00265f, 0f, false, true, -2.90625f, 7.83008f)
                arcTo(40.00041f, 40.00041f, 0f, true, false, 148f, 188f)
                close()
            }
        }.build()
        
        return _thermometerColdBoldSvgrepoCom!!
    }

private var _thermometerColdBoldSvgrepoCom: ImageVector? = null

