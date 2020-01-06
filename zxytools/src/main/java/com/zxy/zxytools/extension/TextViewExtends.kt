package com.kd.kotlin.extend.utils

import android.view.View
import android.widget.TextView

/**
 * Created by zxy on 2020/1/6 0006 14:21
 * ******************************************
 * *
 * ******************************************
 */
fun TextView.zxyText(content: String?) {
    if (content == null) {
        this.zxyVisible()
    } else {
        this.zxyVisible(0)
        this.text = content
    }
}
fun TextView.setColor(resId: Int) {
    this.setTextColor(resources.getColor(resId))
}

fun TextView.setDrawableLeft(resId: Int) {
    var drawable = this.context.resources.getDrawable(resId)
    drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
    this.setCompoundDrawables(drawable, null, null, null)
}

fun TextView.setDrawableRight(resId: Int) {
    var drawable = this.context.resources.getDrawable(resId)
    drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
    this.setCompoundDrawables(null, null, drawable, null)
}

fun TextView.setDrawableTop(resId: Int) {
    var drawable = this.context.resources.getDrawable(resId)
    drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
    this.setCompoundDrawables(null, drawable, null, null)
}

fun TextView.setDrawableBottom(resId: Int) {
    var drawable = this.context.resources.getDrawable(resId)
    drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
    this.setCompoundDrawables(null, null, null, drawable)
}

