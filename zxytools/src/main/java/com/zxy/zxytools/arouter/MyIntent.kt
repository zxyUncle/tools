package com.zxy.zxytools.arouter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import com.zxy.zxytools.R

/**
 * Created by ZXY on 2019/6/6 16:20.
 * Class functions
 * *********************************************************
 * * 跳转
 * *********************************************************
 */
class MyIntent {
    companion object {
        fun startActivity(mContext: Context, zClass: Class<*>) {
            val intent = Intent()
            intent.setClass(mContext, zClass)
            mContext.startActivity(intent)
        }

        fun startActivity(mContext: Context, bundle: Bundle, zClass: Class<*>) {
            val intent = Intent()
            intent.setClass(mContext, zClass)
            intent.putExtras(bundle)
            mContext.startActivity(intent)
        }

        /**
         * 不带参数的转场动画
         * @param mContext Context
         * @param view View
         * @param sharedElementName String
         * @param zClass Class<*>
         */
        fun startActivityOptionsCompat(
            mContext: Context,
            view: View,
            sharedElementName: String,
            zClass: Class<*>
        ) {
            val makeSceneTransitionAnimation =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    mContext as Activity,
                    view,
                    sharedElementName
                )
            val intent = Intent()
            intent.setClass(mContext, zClass)
            mContext.startActivity(intent, makeSceneTransitionAnimation.toBundle())
        }

        /**
         * 有返回值的转场动画
         * @param mContext Context
         * @param view View
         * @param sharedElementName String
         * @param code Int
         * @param zClass Class<*>
         */
        fun startActivityForResultOptionsCompat(
            mContext: Context,
            view: View,
            sharedElementName: String,
            code: Int,
            zClass: Class<*>
        ) {
            val makeSceneTransitionAnimation =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    mContext as Activity,
                    view,
                    sharedElementName
                )
            val intent = Intent()
            intent.setClass(mContext, zClass)
            mContext.startActivityForResult(intent, code, makeSceneTransitionAnimation.toBundle())
        }

        /**
         * 带参数的转场动画
         * @param mContext Context
         * @param view View
         * @param sharedElementName String
         * @param zClass Class<*>
         * @param bundel Bundle
         */
        fun startActivityOptionsCompatBundel(
            mContext: Context,
            view: View,
            sharedElementName: String,
            zClass: Class<*>,
            bundel: Bundle
        ) {
            val makeSceneTransitionAnimation =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    mContext as Activity,
                    view,
                    sharedElementName
                )
            val intent = Intent()
            intent.putExtras(bundel)
            intent.setClass(mContext, zClass)
            mContext.startActivity(intent, makeSceneTransitionAnimation.toBundle())
        }

        /**
         * 有返回值的转场动画
         * @param mContext Context
         * @param view View
         * @param sharedElementName String
         * @param zClass Class<*>
         * @param bundel Bundle
         */
        fun startActivityOptionsCompatBundelResult(
            mContext: Context,
            view: View,
            sharedElementName: String,
            zClass: Class<*>,
            bundel: Bundle
        ) {
            val makeSceneTransitionAnimation =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    mContext as Activity,
                    view,
                    sharedElementName
                )
            val intent = Intent()
            intent.putExtras(bundel)
            intent.setClass(mContext, zClass)
            mContext.startActivityForResult(intent, 1, makeSceneTransitionAnimation.toBundle())
        }

        /**
         * 不带参数的左右转场动画
         * @param mContext Context
         * @param zClass Class<*>
         */
        fun startActivityAnimation(mContext: Context, zClass: Class<*>) {
            val optionsCompat = ActivityOptionsCompat
                .makeCustomAnimation(mContext, R.anim.translate_in, R.anim.translate_out)
            val intent = Intent()
            intent.setClass(mContext, zClass)
            mContext.startActivity(intent, optionsCompat.toBundle())
        }

        /**
         * 不带参数的上下转场动画
         * @param mContext Context
         * @param zClass Class<*>
         */
        fun startActivityAnimationTop(mContext: Context, zClass: Class<*>) {
            val optionsCompat = ActivityOptionsCompat
                .makeCustomAnimation(mContext, R.anim.translate_top, R.anim.translate_bottom)
            val intent = Intent()
            intent.setClass(mContext, zClass)
            mContext.startActivity(intent, optionsCompat.toBundle())
        }

        fun finishLeft(activity: Activity) {
            activity.overridePendingTransition(R.anim.translate_in_back, R.anim.translate_out_back)
            activity.finishAfterTransition()
        }

        fun finishTop(activity: Activity) {
            activity.overridePendingTransition(R.anim.translate_top, R.anim.translate_bottom)
            activity.finishAfterTransition()
        }
    }

}