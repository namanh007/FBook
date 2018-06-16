package com.huy.source

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
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
abstract class MvpFragment<in V : BaseView, P : MvpPresenterInt<V>> : Fragment() {

    /**--------------------------------------------------------------------------------------
     *   [MvpFragment] Initialize variable & method
    ----------------------------------------------------------------------------------------*/
    protected var presenter: P? = null

    protected abstract fun presenter(): P?

    /**--------------------------------------------------------------------------------------
     *   [android.support.v4.app.Fragment] Override
    ----------------------------------------------------------------------------------------*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = presenter()
        @Suppress("UNCHECKED_CAST")
        presenter?.attach(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detach()
    }

}