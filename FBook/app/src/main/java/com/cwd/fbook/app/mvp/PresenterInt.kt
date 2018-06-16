package com.huy.source

import com.cwd.fbook.app.base.BaseView

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
interface PresenterInt<in V : BaseView> {

    fun attach(view: V)

    fun detach()
}