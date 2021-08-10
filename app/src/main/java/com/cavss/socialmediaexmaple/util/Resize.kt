package com.cavss.socialmediaexmaple.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.TypedValue
import androidx.core.content.ContextCompat

object Resize {
    fun statusBar(context : Context) : Int {
        var result = 0
        val resourceID = context.resources.getIdentifier("status_bar_height", "dimen","android")
        if (resourceID > 0) { result = context.resources.getDimensionPixelSize(resourceID)}
        return result
    }

    fun imageResize(context : Context, image : Int, width : Int, height : Int) : Drawable {
        val drawable = ContextCompat.getDrawable(context, image)
        val bitmap = (drawable as BitmapDrawable).bitmap
        return BitmapDrawable(context.resources, Bitmap.createScaledBitmap(bitmap, width, height, true))
    }
}


fun Float.toPx(context : Context) = (this * context.resources.displayMetrics.scaledDensity + 0.5F)
fun Float.toDP(context : Context) : Int {
    val toDP = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, context.resources.displayMetrics).toInt()
    return toDP
}
