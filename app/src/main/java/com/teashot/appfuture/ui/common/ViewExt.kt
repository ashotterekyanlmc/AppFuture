package com.teashot.appfuture.ui.common

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.teashot.appfuture.R

fun ImageView.setGlideImage(url: String? = null) {
    Glide.with(context)
        .load(url ?: R.drawable.enot)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}

var View.visible
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value)
            View.VISIBLE
        else
            View.GONE
    }

fun TextView.setTextString(textStr: String?) {
    if (!textStr.isNullOrEmpty()) {
        visible = true
        text = textStr
    }
}
