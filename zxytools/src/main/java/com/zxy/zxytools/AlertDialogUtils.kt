package com.zxy.zxytools

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.tools_zxy_dialog_msg1.view.*
import android.view.WindowManager


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
    private var cancelable: Boolean = true                          //是否可以取消  true可以
    lateinit var dialog: AlertDialog                        // AlertDilaog
    lateinit var alertDilaogBuilder: AlertDialog.Builder    // AlertDilaog.Builder
    lateinit var listView: MutableList<Int>
    var transparency: Float = 0.5f                              // 透明度

    companion object {
        fun build(mContext: Context): Builder {
            return Builder(mContext)
        }
    }

    class Builder(mContext: Context) {
        var mContext = mContext
        var alertDialogUtils = AlertDialogUtils()
        /**
         * 设置布局
         * @param layoutView View
         */
        fun setView(layoutId: Int): Builder {
            alertDialogUtils.layoutView = LayoutInflater.from(mContext).inflate(layoutId, null)
            return this
        }

        /**
         * 设置点击事件
         * @param viewId IntArray
         */
        fun setOnClick(vararg viewId: Int): Builder {
            alertDialogUtils.listView = viewId.toTypedArray().toMutableList()
            return this
        }

        /**
         * 是否可以取消  默认true可以
         * @param cancelable Boolean
         */
        fun setCancelable(cancelable: Boolean): Builder {
            alertDialogUtils.cancelable = cancelable
            return this
        }

        /**
         * 设置窗口透明度，默认0.5    0为全透明  1全黑
         * @param transparency Float
         * @return Builder
         */
        fun setTransparency(transparency: Float): Builder {
            alertDialogUtils.transparency = transparency
            return this
        }

        /**
         * 创建AlertDialog
         */
        private fun create() {
            alertDialogUtils.alertDilaogBuilder = AlertDialog.Builder(mContext, R.style.MyDilog)
            alertDialogUtils.alertDilaogBuilder.setView(alertDialogUtils.layoutView)
            alertDialogUtils.dialog = alertDialogUtils.alertDilaogBuilder.create()
            alertDialogUtils.dialog.setCancelable(alertDialogUtils.cancelable)
            alertDialogUtils.dialog.show()
            val lp = alertDialogUtils.dialog.window!!.getAttributes()
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            alertDialogUtils.dialog.window!!.setDimAmount(alertDialogUtils.transparency)//设置黑色遮罩层的透明度
            alertDialogUtils.dialog.window!!.setAttributes(lp)
        }


        /**
         * 显示弹出
         */
        fun show(alertDialogUtilsListener: AlertDialogUtilsListener): AlertDialogUtils {

            if (alertDialogUtils.layoutView == null) {
                Toast.makeText(mContext, "AlertDilaog的setView()不能为null", Toast.LENGTH_SHORT).show()
            } else {
                for (index in 0 until alertDialogUtils.listView.size step 1) {
                    alertDialogUtils.layoutView.findViewById<View>(alertDialogUtils.listView[index])
                        .setOnClickListener {
                            alertDialogUtilsListener.onClickDialog(it)
                        }
                }
                create()
            }

            return alertDialogUtils
        }

        /**
         * 样式1
         * @param alertDialogUtilsListener AlertDialogUtilsListener
         * @return AlertDialogUtils
         */
        fun showStyle1(alertDialogUtilsListener: AlertDialogUtilsListener): AlertDialogUtils {
            alertDialogUtils.layoutView = LayoutInflater.from(mContext).inflate(R.layout.tools_zxy_dialog_msg1, null)

            create()

            alertDialogUtils.layoutView.dialog_msg_confirm.setOnClickListener {
                alertDialogUtilsListener.onClickDialog(it)
            }
            alertDialogUtils.layoutView.dialog_msg_cancel.setOnClickListener {
                alertDialogUtilsListener.onClickDialog(it)
            }
            return alertDialogUtils
        }

        /**
         * 样式2
         * @param alertDialogUtilsListener AlertDialogUtilsListener
         * @return AlertDialogUtils
         */
        fun showStyle2(alertDialogUtilsListener: AlertDialogUtilsListener): AlertDialogUtils {
            alertDialogUtils.layoutView = LayoutInflater.from(mContext).inflate(R.layout.tools_zxy_dialog_msg2, null)

            create()

            alertDialogUtils.layoutView.dialog_msg_confirm.setOnClickListener {
                alertDialogUtilsListener.onClickDialog(it)
            }
            alertDialogUtils.layoutView.dialog_msg_cancel.setOnClickListener {
                alertDialogUtilsListener.onClickDialog(it)
            }
            return alertDialogUtils
        }

        interface AlertDialogUtilsListener {
            fun onClickDialog(view: View)
        }
    }


    fun cancel() {
        if (dialog != null)
            dialog!!.cancel()
    }


}