package com.huy.source

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