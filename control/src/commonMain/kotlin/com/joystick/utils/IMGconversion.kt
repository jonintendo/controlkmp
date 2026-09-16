package com.joystick.utils

import androidx.annotation.RequiresApi
import kotlin.io.encoding.Base64


fun ByteArray.toBase64encode(): String {
    return Base64.encode(this)
}