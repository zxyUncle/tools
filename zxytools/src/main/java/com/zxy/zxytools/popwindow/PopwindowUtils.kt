package com.zxy.zxytools.popwindow

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.PopupWindow
import com.zxy.zxytools.R


/**
 * Created by zxy on 2019/12/23 15:32
 * ******************************************
 * * 界面的下方弹出
 * ******************************************
 */
class PopwindowUtils(mContext: Activity) {
    var mContext: Activity? = null
    var popupWindow:PopupWindow?=null

    init {
        this.mContext = mContext
    }

    /**
     * view:位置
     * v：popwindow的布局
     */
    fun showPop(view: View,v:View) {
        popupWindow = PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        popupWindow!!.isTouchable = true
        popupWindow!!.isFocusable = true
        popupWindow!!.animationStyle = R.style.popwin_anim_style;
        popupWindow!!.isOutsideTouchable = true
//        popupWindow.showAsDropDown(view, 0, 0, Gravity.BOTTOM);
        popupWindow!!.showAtLocation(view, Gravity.BOTTOM, 0, 0)
        //设置遮罩层
        backgroundAlpha(0.5f)
        popupWindow!!.setOnDismissListener(object : PopupWindow.OnDismissListener {
            override fun onDismiss() {
                backgroundAlpha(1f)
                //**重点，清理掉浮动的遮罩层，否则使用转场动画的时候会有黑色背景，因为dismiss是隐藏不是销毁
                mContext?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            }
        })
    }
    fun dismiss(){
        popupWindow?.dismiss()
    }

    private fun backgroundAlpha(f: Float) {
        val attributesNew = mContext?.window?.attributes
        attributesNew?.alpha = f
        mContext?.window?.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        mContext?.window?.attributes = attributesNew
    }

}