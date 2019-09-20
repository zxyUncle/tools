package com.zxy.tools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.zxy.zxytools.dialog.AlertDialogUtils
import com.zxy.zxytools.logger.LoggerUtils


class MainActivity : AppCompatActivity() {
    lateinit var alertDialogUtils: AlertDialogUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //https://github.com/orhanobut/logger
        LoggerUtils.init("msg")
        Logger.d("debug")
        Logger.e("error")
        Logger.w("warning")
        Logger.v("verbose")
        Logger.t("121").i("information")
        Logger.xml("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "          package=\"com.zxy.tools\">\n" +
                "\n" +
                "    <application\n" +
                "            android:allowBackup=\"true\"\n" +
                "            android:icon=\"@mipmap/ic_launcher\"\n" +
                "            android:label=\"@string/app_name\"\n" +
                "            android:roundIcon=\"@mipmap/ic_launcher_round\"\n" +
                "            android:supportsRtl=\"true\"\n" +
                "            android:theme=\"@style/AppTheme\">\n" +
                "        <activity android:name=\".MainActivity\">\n" +
                "            <intent-filter>\n" +
                "                <action android:name=\"android.intent.action.MAIN\"/>\n" +
                "\n" +
                "                <category android:name=\"android.intent.category.LAUNCHER\"/>\n" +
                "            </intent-filter>\n" +
                "        </activity>\n" +
                "    </application>\n" +
                "\n" +
                "</manifest>")
        Logger.json("{\n" +
                "    \"code\": \"00\",\n" +
                "    \"msg\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"uid\": \"201874\",\n" +
                "        \"type\": \"F\",\n" +
                "        \"channel\": \"\",\n" +
                "        \"userName\": \"18501617787\",\n" +
                "        \"avatar\": \"U/20181128/038e56ebc74448f0ba7333999cd57857\",\n" +
                "        \"accessToken\": \"A1E2LzxhUGFZvZyFAwzs70G6lx40cUBmVQIqhFiEYX/b4mQ=\",\n" +
                "        \"tokenType\": \"Bearer\",\n" +
                "        \"expires\": 604800,\n" +
                "        \"refreshToken\": \"439cd7cb2a69a011\",\n" +
                "        \"timestamp\": 1568890345144,\n" +
                "        \"inviteCode\": \"3640\",\n" +
                "        \"isExist\": 0\n" +
                "    }\n" +
                "}")
    }


    fun onStyle1(view: View) {
        alertDialogUtils =
            AlertDialogUtils
                .build(this)
                .showStyle1()                   //必选  显示样式1
                .setTransparency(0.4f)          //可选  设置窗口透明度，默认0.5
                .setTitle("我是元婴期")          //可选  设置标题
                .setConfirm("左手大保健")        //可选  确定按钮文案
                .setCancel("右手打和尚")         //可选  取消按钮文案
                .setTitleColor(resources.getColor(R.color.colorAccent,null)) //或者 0xD81B60      //可选  设置标题颜色
                .setConfirmColor(resources.getColor(R.color.colorAccent,null)) //或者 0xD81B60    //可选  确定按钮颜色
                .setCancelColor(resources.getColor(R.color.colorAccent,null)) //或者 0xD81B60     //可选  取消按钮颜色
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
                .showStyle2()                   //必选    显示样式2
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
        //可选  设置按钮的字体大小，文字样式等等
//        val layoutView = alertDialogUtils.layoutView
//        layoutView.findViewById<TextView>(R.id.dialog_msg_title1).textSize=16f
//        layoutView.findViewById<TextView>(R.id.dialog_msg_cancel1).textSize=16f
//        layoutView.findViewById<TextView>(R.id.dialog_msg_confirm1).textSize=16f

    }

    fun onCoustDikaog(view: View) {
        alertDialogUtils = AlertDialogUtils.build(this)
            .setView(R.layout.dialog_button)    //必选 设置布局View
            .setCancelable(true)                //可选 设置是否可以取消，默认true
            .setTransparency(0f)                //可选 设置窗口透明度，默认0.5
            .setOnClick(R.id.but1, R.id.but2, R.id.but3)    //可选 设置布局的点击事件
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
