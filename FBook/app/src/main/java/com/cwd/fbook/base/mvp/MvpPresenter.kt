package com.huy.source

import android.support.annotation.StringRes

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
open class MvpPresenter<V : MvpViewInt> : MvpPresenterInt<V>{

    protected var view: V? = null

    override fun attach(view: V) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    fun string(@StringRes stringRes: Int) : String?{
        return view?.string(stringRes)
    }

}