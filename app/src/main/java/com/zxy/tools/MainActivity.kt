package com.zxy.tools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.zxy.zxytools.AlertDialogUtils

class MainActivity : AppCompatActivity() {
    lateinit var alertDialogUtils: AlertDialogUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onStyle1(view: View) {
        alertDialogUtils =
            AlertDialogUtils
                .build(this)
                .showStyle1()                   //必选  显示样式1
//                .setTransparency(0.4f)          //可选  设置窗口透明度，默认0.5
//                .setTitle("我是元婴期")          //可选  设置标题
//                .setConfirm("左手大保健")        //可选  确定按钮文案
//                .setCancel("右手打和尚")         //可选  取消按钮文案
//                .setTitleColor(resources.getColor(R.color.colorAccent,null)) //或者 0xD81B60      //可选  设置标题颜色
//                .setConfirmColor(resources.getColor(R.color.colorAccent,null)) //或者 0xD81B60    //可选  确定按钮颜色
//                .setCancelColor(resources.getColor(R.color.colorAccent,null)) //或者 0xD81B60     //可选  取消按钮颜色
                .create(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
                    override fun onClickDialog(view: View) {
                        when (view.id) {
                            R.id.dialog_msg_confirm1 -> {
                                Toast.makeText(this@MainActivity, "确定", Toast.LENGTH_SHORT).show()
                            }
                            R.id.dialog_msg_cancel1 -> {
                                Toast.makeText(this@MainActivity, "取消", Toast.LENGTH_SHORT).show()
                            }
                        }
                        alertDialogUtils.cancel()
                    }
                })
        //可选  设置按钮的字体大小，文字样式等等
//        val layoutView = alertDialogUtils.layoutView
//        layoutView.findViewById<TextView>(R.id.dialog_msg_title1).textSize=16f
//        layoutView.findViewById<TextView>(R.id.dialog_msg_cancel1).textSize=16f
//        layoutView.findViewById<TextView>(R.id.dialog_msg_confirm1).textSize=16f

    }

    fun onStyle2(view: View) {

        alertDialogUtils =
            AlertDialogUtils
                .build(this)
                .showStyle1()                   //显示样式1 0xD81B60
                .create(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
                    override fun onClickDialog(view: View) {
                        when (view.id) {
                            R.id.dialog_msg_confirm1 -> {
                                Toast.makeText(this@MainActivity, "确定", Toast.LENGTH_SHORT).show()
                            }
                            R.id.dialog_msg_cancel1 -> {
                                Toast.makeText(this@MainActivity, "取消", Toast.LENGTH_SHORT).show()
                            }
                        }
                        alertDialogUtils.cancel()
                    }
                })

        alertDialogUtils =
            AlertDialogUtils
                .build(this)
                .showStyle2()                   //显示样式2
                .setTransparency(0.4f)         //设置窗口透明度，默认0.5
                .setTitle("张三疯标题")
                .setConfirm("你好")
                .setCancel("我不好")
                .create(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
                    override fun onClickDialog(view: View) {
                        when (view.id) {
                            R.id.dialog_msg_confirm2 -> {
                                Toast.makeText(this@MainActivity, "确定", Toast.LENGTH_SHORT).show()
                            }
                            R.id.dialog_msg_cancel2 -> {
                                Toast.makeText(this@MainActivity, "取消", Toast.LENGTH_SHORT).show()
                            }
                        }
                        alertDialogUtils.cancel()
                    }
                })
    }

    fun onCoustDikaog(view: View) {
        alertDialogUtils = AlertDialogUtils.build(this)
            .setView(R.layout.dialog_button)    //设置布局View
            .setCancelable(true)                //设置是否可以取消，默认true
            .setTransparency(0f)                //设置窗口透明度，默认0.5
            .setOnClick(R.id.but1, R.id.but2, R.id.but3)    //设置布局的点击事件
            .create(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
                override fun onClickDialog(view: View) {
                    when (view.id) {
                        R.id.but1 -> {
                            Toast.makeText(this@MainActivity, "but1", Toast.LENGTH_SHORT).show()
                        }
                        R.id.but2 -> {
                            Toast.makeText(this@MainActivity, "but2", Toast.LENGTH_SHORT).show()
                        }
                        R.id.but3 -> {
                            Toast.makeText(this@MainActivity, "but3", Toast.LENGTH_SHORT).show()
                        }
                    }
                    alertDialogUtils.cancel()   //取消Dialog
                }
            })
    }
}
