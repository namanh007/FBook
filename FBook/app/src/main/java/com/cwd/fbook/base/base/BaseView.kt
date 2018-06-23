package com.huy.source

import android.support.annotation.StringRes

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
interface BaseView {

    fun toast(charSequence: CharSequence)

    fun toast(@StringRes stringRes: Int)

    fun notify(charSequence: CharSequence)

    fun notify(@StringRes stringRes: Int)

    fun showProcessView()

    fun hideProcessView()


}