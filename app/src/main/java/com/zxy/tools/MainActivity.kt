package com.zxy.tools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.zxy.zxytools.arouter.MyIntent
import com.zxy.zxytools.extension.clickWithTrigger
import com.zxy.zxytools.snackbar.Prompt
import com.zxy.zxytools.snackbar.TSnackbar
import com.zxy.zxytools.snackbar.TSnackbar.APPEAR_FROM_TOP_TO_DOWN
import com.zxy.zxytools.snackbar.ZToast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_main.clickWithTrigger {
            MyIntent.startActivityAnimation(this, FirstActivity::class.java)
        }

        btn_main_toast.clickWithTrigger {
            ZToast.showI(this,"账号或者密码错误")
        }
        btn_main_toast1.clickWithTrigger {
            ZToast.showI(this,"确定退出")
        }
    }
}
