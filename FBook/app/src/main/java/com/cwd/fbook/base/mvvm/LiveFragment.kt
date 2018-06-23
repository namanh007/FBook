package com.huy.source

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.View

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
abstract class LiveFragment : BaseFragment(){

    @LayoutRes
    protected abstract fun layout(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}