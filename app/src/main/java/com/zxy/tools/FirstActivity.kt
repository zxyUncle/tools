package com.zxy.tools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import com.zxy.zxytools.arouter.MyIntent

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        MyIntent.finishLeft(this)
    }

}
