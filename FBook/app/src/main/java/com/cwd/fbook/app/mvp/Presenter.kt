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
open class Presenter<V : BaseView> : PresenterInt<V> {

    protected var view: V? = null

    override fun attach(view: V) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

}