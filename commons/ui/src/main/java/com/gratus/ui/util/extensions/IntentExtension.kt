package com.gratus.ui.util.extensions

import android.content.Context
import android.content.Intent

inline fun <reified T> Context.startActivity() {
    val i = Intent(this, T::class.java)
    startActivity(i)
}
