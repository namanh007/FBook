package com.huy.source

import android.os.Bundle
import com.cwd.fbook.base.BaseActivity

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
abstract class LiveActivity<VM : ViewModel> : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}