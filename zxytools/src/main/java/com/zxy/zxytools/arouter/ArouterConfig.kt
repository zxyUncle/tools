package com.zxy.zxytools.arouter

import android.content.Context
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat
import com.alibaba.android.arouter.launcher.ARouter
import com.zxy.zxytools.R

/**
 * Created by zxy on 2019/9/26-13:50
 * Class functions
 * ******************************************
 * * 路由配置
 * ******************************************
 */
class ArouterConfig {
    companion object {
        //ZXY 路径
        //app模块主路由
        const val appModule: String = "/app/"
        //uikit模块主路由 -网易云信界面
        const val uikitModule: String = "/app/"

        //登录
        const val LOGIN: String = appModule + "login"
        //主页
        const val HOME: String = appModule + "home"


        //ZXY 跳转方法
        /**
         * 普通跳转
         * @param url String
         * @param mContext Context
         */
        fun post(mContext: Context, url: String, bundle: Bundle? = null) {
            ARouter.getInstance()
                .build(url)
                .withBundle("key", bundle)
                .navigation(mContext)
        }

        /**
         * 左出又进的动画跳转
         * @param url String
         * @param mContext Context
         */
        fun postToRight(mContext: Context, url: String, bundle: Bundle? = null) {
            var makeCustomAnimation = ActivityOptionsCompat
                .makeCustomAnimation(mContext, R.anim.translate_out, R.anim.translate_in)
            ARouter.getInstance()
                .build(url)
                .withBundle("key", bundle)
                .withOptionsCompat(makeCustomAnimation)
                .navigation(mContext)
        }

        /**
         * 上出下进的动画跳转
         * @param url String
         * @param mContext Context
         */
        fun postToTop(mContext: Context, url: String, bundle: Bundle? = null) {
            var makeCustomAnimation = ActivityOptionsCompat
                .makeCustomAnimation(mContext, R.anim.translate_top, R.anim.translate_bottom)
            ARouter.getInstance()
                .build(url)
                .withBundle("key", bundle)
                .withOptionsCompat(makeCustomAnimation)
                .navigation(mContext)
        }

    }

}