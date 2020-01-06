package com.zxy.tools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zxy.zxytools.arouter.MyIntent
import com.zxy.zxytools.extension.clickWithTrigger
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_main.clickWithTrigger {
            MyIntent.startActivityAnimation(this, FirstActivity::class.java)
        }

    }
}
