package com.kd.kotlin.extend.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide


/**
 * 加载图片
 */
fun ImageView.loadImage(context: Context, path: String, placeholder: Int , useCache: Boolean = false) {
//    Glide.with(context).load(path).apply(options).into(this)
}

/**
 * 加载圆形图片
 */
fun ImageView.loadCircleImage(context: Context, path: String, placeholder: Int , useCache: Boolean = false) {
//    Glide.with(context).load(path).apply(options).into(this)
}

/**
 * 加载圆角图片
 */
fun ImageView.loadRoundCornerImage(context: Context, path: String, roundingRadius: Int = 20, placeholder: Int , useCache: Boolean = false) {
//    Glide.with(context).load(path).apply(RequestOptions.bitmapTransform(RoundedCorners(roundingRadius))).apply(options).into(this)
}

/**
 * 取消加载
 */
fun ImageView.loadClear(context: Context) {
    Glide.with(context).clear(this)
}




