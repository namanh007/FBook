package com.cwd.fbook.util

import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 **************************************************************************************************
 * 
 *  @Project: FBook
 *  @CreatedBy: Huy AgilSun Quoc Vu 2018-06-14
 *  @LastEditor: Huy AgilSun Quoc Vu 2018-06-14
 *  @Description: ...
 *
 *                                      All Right Reserved.
 *
 **************************************************************************************************
 */
fun <T : View> View.find(@IdRes resId: Int): Lazy<T> {

    @Suppress("UNCHECKED_CAST")
    return lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(resId) }
}

fun <T : View> View.bind(@IdRes resId: Int): T {

    @Suppress("UNCHECKED_CAST")
    return findViewById(resId)
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}