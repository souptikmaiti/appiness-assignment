package com.souptik.maiti.souptikappinesstask.utils

import android.content.Context
import android.graphics.PorterDuff
import android.widget.TextView
import androidx.core.content.ContextCompat

object Toaster {
    fun showShort(context: Context, text: CharSequence) {
        val toast = android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_SHORT)
        toast.show()
    }

    fun showLong(context: Context, text: CharSequence) {
        val toast = android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_LONG)
        toast.show()
    }
}