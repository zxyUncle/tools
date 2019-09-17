package com.zxy.zxytools

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.tools_zxy_dialog_msg1.view.*
import android.view.WindowManager
import android.widget.TextView
import kotlinx.android.synthetic.main.tools_zxy_dialog_msg2.view.*


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
    var TYPE: Int = 4                                           //三种类型 1=样式1    2=样式2     3=自定义样式  4=自定义布局不能为null

    companion object {
        fun build(mContext: Context): Builder {
            return Builder(mContext)
        }
    }

    class Builder(mContext: Context) {
        var mContext = mContext
        var alertDialogUtils = AlertDialogUtils()

        /**
         * 自定义接口
         */
        interface AlertDialogUtilsListener {
            fun onClickDialog(view: View)
        }

        /**
         * 设置布局
         * @param layoutView View
         */
        fun setView(layoutId: Int): Builder {
            alertDialogUtils.layoutView = LayoutInflater.from(mContext).inflate(layoutId, null)
            if (alertDialogUtils.layoutView == null) {
                alertDialogUtils.TYPE = 4
            } else {
                alertDialogUtils.TYPE = 3
            }
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
         * 样式1
         * @param alertDialogUtilsListener AlertDialogUtilsListener
         * @return Builder
         */
        fun showStyle1(): Builder {
            alertDialogUtils.layoutView = LayoutInflater.from(mContext).inflate(R.layout.tools_zxy_dialog_msg1, null)
            alertDialogUtils.TYPE = 1
            return this
        }


        /**
         * 样式2
         * @param alertDialogUtilsListener AlertDialogUtilsListener
         * @return AlertDialogUtils
         */
        fun showStyle2(): Builder {
            alertDialogUtils.layoutView = LayoutInflater.from(mContext).inflate(R.layout.tools_zxy_dialog_msg2, null)
            alertDialogUtils.TYPE = 2
            return this
        }

        /**
         * 设置自定样式的标题
         * @param title String
         * @return Builder
         */
        fun setTitle(title: String): Builder {
            if (alertDialogUtils.TYPE == 1) {
                var tvTitle1 = alertDialogUtils.layoutView.findViewById<TextView>(R.id.dialog_msg_title1)
                tvTitle1.text = title
            } else if (alertDialogUtils.TYPE == 2) {
                var tvTitle2 = alertDialogUtils.layoutView.findViewById<TextView>(R.id.dialog_msg_title2)
                tvTitle2.text = title
            }
            return this
        }
        /**
         * 设置自定义样式的标题颜色
         * @param color Int
         */
        fun setTitleColor(color:Int):Builder{
            if (alertDialogUtils.TYPE == 1) {
                var tvTitle1 = alertDialogUtils.layoutView.findViewById<TextView>(R.id.dialog_msg_title1)
                tvTitle1.setTextColor(color)
            } else if (alertDialogUtils.TYPE == 2) {
                var tvTitle2 = alertDialogUtils.layoutView.findViewById<TextView>(R.id.dialog_msg_title2)
                tvTitle2.setTextColor(color)
            }
            return this
        }

        /**
         * 设置自定义样式的确定文案
         * @param confirm String
         */
        fun setConfirm(confirm: String): Builder {
            if (alertDialogUtils.TYPE == 1) {
                var tvConfirm1 = alertDialogUtils.layoutView.findViewById<TextView>(R.id.dialog_msg_confirm1)
                tvConfirm1.text = confirm
            } else if (alertDialogUtils.TYPE == 2) {
                var tvConfirm2 = alertDialogUtils.layoutView.findViewById<TextView>(R.id.dialog_msg_confirm2)
                tvConfirm2.text = confirm
            }
            return this
        }
        /**
         * 设置自定义样式的确定颜色
         * @param color Int
         */
        fun setConfirmColor(color:Int):Builder{
            if (alertDialogUtils.TYPE == 1) {
                var tvConfirm1 = alertDialogUtils.layoutView.findViewById<TextView>(R.id.dialog_msg_confirm1)
                tvConfirm1.setTextColor(color)
            } else if (alertDialogUtils.TYPE == 2) {
                var tvConfirm2 = alertDialogUtils.layoutView.findViewById<TextView>(R.id.dialog_msg_confirm2)
                tvConfirm2.setTextColor(color)
            }
            return this
        }

        /**
         * 设置自定义样式的取消文案
         * @param confirm String
         */
        fun setCancel(cancel: String): Builder {
            if (alertDialogUtils.TYPE == 1) {
                var tvCancel1 = alertDialogUtils.layoutView.findViewById<TextView>(R.id.dialog_msg_cancel1)
                tvCancel1.text = cancel
            } else if (alertDialogUtils.TYPE == 2) {
                var tvCance2 = alertDialogUtils.layoutView.findViewById<TextView>(R.id.dialog_msg_cancel2)
                tvCance2.text = cancel
            }
            return this
        }
        /**
         * 设置自定义样式的取消颜色
         * @param confirm String
         */
        fun setCancelColor(color: Int): Builder {
            if (alertDialogUtils.TYPE == 1) {
                var tvCancel1 = alertDialogUtils.layoutView.findViewById<TextView>(R.id.dialog_msg_cancel1)
                tvCancel1.setTextColor(color)
            } else if (alertDialogUtils.TYPE == 2) {
                var tvCance2 = alertDialogUtils.layoutView.findViewById<TextView>(R.id.dialog_msg_cancel2)
                tvCance2.setTextColor(color)
            }
            return this
        }

        /**
         * 创建AlertDialog
         */
        fun create(alertDialogUtilsListener: AlertDialogUtilsListener): AlertDialogUtils {
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

            when (alertDialogUtils.TYPE) {
                1 -> {//样式1
                    alertDialogUtils.layoutView.dialog_msg_confirm1.setOnClickListener {
                        alertDialogUtilsListener.onClickDialog(it)
                    }
                    alertDialogUtils.layoutView.dialog_msg_cancel1.setOnClickListener {
                        alertDialogUtilsListener.onClickDialog(it)
                    }
                }
                2 -> {
                    alertDialogUtils.layoutView.dialog_msg_confirm2.setOnClickListener {
                        alertDialogUtilsListener.onClickDialog(it)
                    }
                    alertDialogUtils.layoutView.dialog_msg_cancel2.setOnClickListener {
                        alertDialogUtilsListener.onClickDialog(it)
                    }
                }
                3 -> {
                    for (index in 0 until alertDialogUtils.listView.size step 1) {
                        alertDialogUtils.layoutView.findViewById<View>(alertDialogUtils.listView[index])
                            .setOnClickListener {
                                alertDialogUtilsListener.onClickDialog(it)
                            }
                    }
                }
                else -> {
                    Toast.makeText(mContext, "AlertDilaog的setView()不能为null", Toast.LENGTH_SHORT).show()
                }
            }
            return alertDialogUtils
        }


    }


    fun cancel() {
        if (dialog != null)
            dialog!!.cancel()
    }


}