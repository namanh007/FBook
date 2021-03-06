package com.huy.source

import android.os.Bundle

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @LastEditor: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
abstract class MvpActivity<in V : BaseView, P : MvpPresenterInt<V>> : BaseActivity(), MvpViewInt {

    /**--------------------------------------------------------------------------------------
     *   [MvpActivity] Initialize variable & method
    ----------------------------------------------------------------------------------------*/
    protected var presenter: P? = null

    protected abstract fun presenter(): P?

    /**--------------------------------------------------------------------------------------
     *   [android.support.v7.app.AppCompatActivity] Override
    ----------------------------------------------------------------------------------------*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = presenter()
        @Suppress("UNCHECKED_CAST")
        presenter?.attach(this as V)
        onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detach()
    }
}

