package com.cwd.fbook.app.mvvm

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.View
import com.cwd.fbook.app.base.BaseFragment

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
abstract class LiveFragment : BaseFragment(){

    @LayoutRes
    protected abstract fun layout(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}