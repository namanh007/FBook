package com.huy.source

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @LastEditor: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
open class MvpPresenter<V : BaseView> : MvpPresenterInt<V>{

    protected var view: V? = null

    override fun attach(view: V) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

}