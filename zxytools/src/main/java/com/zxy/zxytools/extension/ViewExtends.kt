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
 * visible:0-VISIBLE
 *  visible:1-GONE
 *   visible:orther-INVISIBLE
 */
fun View.zxyVisible(visible: Int = 2) {
    if (visible == 0) {
        this.visibility = View.VISIBLE
    } else if (visible == 1) {
        this.visibility = View.GONE
    } else {
        this.visibility = View.INVISIBLE
    }
}