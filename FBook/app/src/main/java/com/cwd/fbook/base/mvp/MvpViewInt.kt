package com.huy.source

import android.support.annotation.StringRes
import com.cwd.fbook.base.BaseView

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
interface MvpViewInt : BaseView {

    fun string(@StringRes stringRes: Int) : String
}