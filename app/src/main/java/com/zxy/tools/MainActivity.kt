package com.zxy.tools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zxy.zxytools.dialog.AlertDialogUtils


class MainActivity : AppCompatActivity() {
    lateinit var alertDialogUtils: AlertDialogUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
