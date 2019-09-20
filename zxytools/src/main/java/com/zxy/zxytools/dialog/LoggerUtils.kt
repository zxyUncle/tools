package com.zxy.zxytools.dialog

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

/**
 * Created by zxy on 2019/9/20-13:14
 * Class functions
 * ******************************************
 * *
 * ******************************************
 */
class LoggerUtils {
    companion object {
        lateinit var formatStrategy: PrettyFormatStrategy
        fun init(TAG: String) { //日志过滤标记
            formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // 是否显示线程信息 默认显示 上图Thread Infrom的位置
                .methodCount(1)         // 展示方法的行数 默认是2  上图Method的行数
                .methodOffset(0)        // 内部方法调用向上偏移的行数 默认是0
                //.logStrategy(customLog) // 改变log打印的策略一种是写本地，一种是logcat显示 默认是后者（当然也可以自己定义）
                .tag(TAG)   // 自定义全局tag 默认：PRETTY_LOGGER
                .build()

            Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
                override fun isLoggable(priority: Int, tag: String?): Boolean {
                    return true
                }
            })
        }
    }
}