package com.cwd.fbook.util

import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import android.view.View

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
fun <T : View> RecyclerView.ViewHolder.find(@IdRes resId: Int): Lazy<T> {

    @Suppress("UNCHECKED_CAST")
    return lazy(LazyThreadSafetyMode.NONE) { itemView!!.findViewById<T>(resId) }
}

fun <T : View> RecyclerView.ViewHolder.bind(@IdRes resId: Int): T {

    @Suppress("UNCHECKED_CAST")
    return itemView!!.findViewById(resId)
}