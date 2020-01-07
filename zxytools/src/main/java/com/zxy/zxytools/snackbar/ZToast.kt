package com.zxy.zxytools.snackbar

import android.app.Activity
import android.content.Context

/**
 * Created by zxy on 2020/1/7 0007 13:40
 * ******************************************
 * *
 * ******************************************
 */
class ZToast {
    companion object {
        fun showI(mContext: Activity, message: String) {
            val rootView = mContext.window.decorView.rootView
            var snackBar = TSnackbar.make(
                rootView, message, TSnackbar.LENGTH_SHORT,
                TSnackbar.APPEAR_FROM_TOP_TO_DOWN
            )
            snackBar.setPromptThemBackground(Prompt.WARNING)
            snackBar.show()
        }
    }
}