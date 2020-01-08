package com.zxy.tools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zxy.zxytools.arouter.MyIntent
import com.zxy.zxytools.extension.clicks
import com.zxy.zxytools.snackbar.ZToast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clicks(btn_main_toast, btn_main_toast1, btn_main) {
            onClick(it)
        }
    }

    private fun onClick(view: View) {
        when (view.id) {
            R.id.btn_main_toast -> {
                ZToast.showI(this, "账号或者密码错误")
            }
            R.id.btn_main_toast1 -> {
                ZToast.showI(this, "确定退出")
            }
            R.id.btn_main -> {
                MyIntent.startActivityAnimation(this, FirstActivity::class.java)
            }
        }
    }
}
