package com.huy.source

import android.os.Bundle
import android.view.View

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
abstract class MvpFragment<in V : BaseView, P : MvpPresenterInt<V>> : BaseFragment(),
        MvpViewInt {

    /**
     * [MvpFragment] Initialize variable & method
     */
    protected var presenter: P? = null

    protected abstract fun presenter(): P?

    /**
     * [android.support.v4.app.Fragment] Override
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = presenter()
        @Suppress("UNCHECKED_CAST")
        presenter?.attach(this as V)
        onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detach()
    }

    override fun string(stringRes: Int) = getString(stringRes)
}