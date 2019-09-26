package com.kd.kotlin.extend.utils

import android.view.View
/**
 * Created by zxy on 2019/8/24-10:13
 * Class functions
 * ******************************************
 * * View 的扩展
 * ******************************************
 */

/**
 * 控件的显示跟隐藏
 * @receiver View
 * @param isShow Boolean 默认true
 */
fun View.visibility(isShow:Boolean = true){
    if(isShow){
        this.visibility = View.VISIBLE
    }else{
        this.visibility = View.GONE
    }
}