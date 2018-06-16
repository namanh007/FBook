package com.cwd.fbook.app.base

import android.support.annotation.StringRes

/**
 **************************************************************************************************
 * 
 *  @Project: FBook
 *  @CreatedBy: Huy AgilSun Quoc Vu 2018-06-16
 *  @LastEditor: Huy AgilSun Quoc Vu 2018-06-16
 *  @Description: ...
 *
 *                                      All Right Reserved.
 *
 **************************************************************************************************
 */
interface BaseView {

    fun toast(charSequence: CharSequence)

    fun toast(@StringRes stringRes: Int)

    fun notify(charSequence: CharSequence)

    fun notify(@StringRes stringRes: Int)

    fun showProcessView()

    fun hideProcessView()
}