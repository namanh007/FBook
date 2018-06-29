package com.huy.source

import com.cwd.fbook.base.BaseView

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
interface MvpPresenterInt<in V : BaseView> {

    fun attach(view: V)

    fun detach()
}