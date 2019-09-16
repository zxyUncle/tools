package com.zxy.zxytools

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast

/**
 * Created by zxy on 2019/8/24-10:13
 * Class functions
 * ******************************************
 * * 建造者模式
 * * 自定义万能布局AletDialog
 * ******************************************
 */
class AlertDialogUtils private constructor() {
    lateinit var layoutView: View                           //Dialog的布局文件
    var cancelable: Boolean = true                          //是否可以取消  true可以
    lateinit var dialog: AlertDialog                        // AlertDilaog
    lateinit var alertDilaogBuilder: AlertDialog.Builder    // AlertDilaog.Builder

    companion object {
        fun build(mContext:Context): Builder {
            return Builder(mContext)
        }
    }

    class Builder(mContext:Context) {
        var mContext = mContext
        var alertDialogUtils = AlertDialogUtils()
        /**
         * 设置布局
         * @param layoutView View
         */
        fun setView(layoutView: View) {
            alertDialogUtils.layoutView = layoutView
        }

        /**
         * 设置点击事件
         * @param viewId IntArray
         */
        fun setOnClick(vararg viewId: Int) {

        }

        /**
         * 是否可以取消  默认true可以
         * @param cancelable Boolean
         */
        fun setCancelable(cancelable: Boolean) {
            alertDialogUtils.cancelable = cancelable
        }

        /**
         * 显示弹出
         */
        fun show(): AlertDialogUtils {
            if(alertDialogUtils.layoutView==null){
                Toast.makeText(mContext,"AlertDilaog的setView()不能为null",Toast.LENGTH_SHORT).show()
            }else {
                alertDialogUtils.alertDilaogBuilder = AlertDialog.Builder(mContext, R.style.MyDilog)
                alertDialogUtils.alertDilaogBuilder.setView(alertDialogUtils.layoutView)
                alertDialogUtils.dialog = alertDialogUtils.alertDilaogBuilder.create()
                alertDialogUtils.dialog.setCancelable(alertDialogUtils.cancelable)
                alertDialogUtils.dialog.show()
            }

            return alertDialogUtils
        }

        fun showStyle1(){
            alertDialogUtils.layoutView = LayoutInflater.from(mContext).inflate(R.layout.tools_zxy_dialog_msg,null)

            alertDialogUtils.alertDilaogBuilder = AlertDialog.Builder(mContext, R.style.MyDilog)
            alertDialogUtils.alertDilaogBuilder.setView(alertDialogUtils.layoutView)
            alertDialogUtils.dialog = alertDialogUtils.alertDilaogBuilder.create()
            alertDialogUtils.dialog.setCancelable(alertDialogUtils.cancelable)
            alertDialogUtils.dialog.show()
        }
    }

    fun cancel() {
        if (dialog != null)
            dialog!!.cancel()
    }


}