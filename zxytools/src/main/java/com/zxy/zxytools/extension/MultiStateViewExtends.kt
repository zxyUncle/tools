package com.zxy.zxytools.extension

import com.kennyc.view.MultiStateView

/**
 * Created by zxy on 2019/9/26-10:20
 * Class functions
 * ******************************************
 * * 多状态布局的扩展
 * ******************************************
 */
/**
 * 设置并默认显示内容布局
 * @receiver MultiStateView
 * @param layoutRes Int
 * @param status ViewState
 */
fun MultiStateView.setContent(layoutRes: Int,status:MultiStateView.ViewState=MultiStateView.ViewState.CONTENT){
    //多状态布局，将内容布局放入内容状态中
    this.setViewForState(layoutRes, status)
    //显示内容布局
    this.viewState = status
}

/**
 * 设置并显示空布局
 * @receiver MultiStateView
 * @param layoutRes Int
 * @param status ViewState
 */
fun MultiStateView.setEmpty(layoutRes: Int,status:MultiStateView.ViewState=MultiStateView.ViewState.EMPTY){
    //多状态布局，将内容布局放入内容状态中
    this.setViewForState(layoutRes, status)
    //显示内容布局
    this.viewState = status
}

/**
 * 设置并显示错误布局
 * @receiver MultiStateView
 * @param layoutRes Int
 * @param status ViewState
 */
fun MultiStateView.setError(layoutRes: Int,status:MultiStateView.ViewState=MultiStateView.ViewState.ERROR){
    //多状态布局，将内容布局放入内容状态中
    this.setViewForState(layoutRes, status)
    //显示内容布局
    this.viewState = status
}
/**
 * 设置并显示加载中布局
 * @receiver MultiStateView
 * @param layoutRes Int
 * @param status ViewState
 */
fun MultiStateView.setLoading(layoutRes: Int,status:MultiStateView.ViewState=MultiStateView.ViewState.LOADING){
    //多状态布局，将内容布局放入内容状态中
    this.setViewForState(layoutRes, status)
    //显示内容布局
    this.viewState = status
}
/**
 * 显示指定的布局-默认内容布局
 * @receiver MultiStateView
 * @param status ViewState
 */
fun MultiStateView.setVisibility(status:MultiStateView.ViewState=MultiStateView.ViewState.CONTENT){
    //显示指定的布局
    this.viewState = MultiStateView.ViewState.CONTENT
}