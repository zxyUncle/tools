package com.zxy.tools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
                .setTransparency(0.4f)
                .showStyle1(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
                    override fun onClickDialog(view: View) {
                        when (view.id) {
                            R.id.dialog_msg_confirm -> {
                                Toast.makeText(this@MainActivity, "确定", Toast.LENGTH_SHORT).show()
                            }
                            R.id.dialog_msg_cancel -> {
                                Toast.makeText(this@MainActivity, "取消", Toast.LENGTH_SHORT).show()
                            }
                        }
                        alertDialogUtils.cancel()
                    }
                })
    }

    fun onStyle2(view: View) {
        alertDialogUtils =
            AlertDialogUtils
                .build(this)
                .setTransparency(0.8f)
                .showStyle2(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
                    override fun onClickDialog(view: View) {
                        when (view.id) {
                            R.id.dialog_msg_confirm -> {
                                Toast.makeText(this@MainActivity, "确定", Toast.LENGTH_SHORT).show()
                            }
                            R.id.dialog_msg_cancel -> {
                                Toast.makeText(this@MainActivity, "取消", Toast.LENGTH_SHORT).show()
                            }
                        }
                        alertDialogUtils.cancel()
                    }
                })
    }

    fun onCoustDikaog(view: View) {
        alertDialogUtils = AlertDialogUtils.build(this)
            .setView(R.layout.dialog_button)
            .setCancelable(true)
            .setTransparency(0f)
            .setOnClick(R.id.but1, R.id.but2, R.id.but3)
            .show(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
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
                    alertDialogUtils.cancel()
                }
            })
    }
}
