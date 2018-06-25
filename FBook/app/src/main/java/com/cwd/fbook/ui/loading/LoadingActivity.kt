package com.cwd.fbook.ui.loading

import android.os.Handler
import com.cwd.fbook.R
import com.cwd.fbook.ui.login.LogInActivity
import com.cwd.fbook.util.finish
import com.huy.source.MvpActivity
import kotlinx.android.synthetic.main.activity_loading.*

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class LoadingActivity : MvpActivity<LoadingContract.View, LoadingContract.Presenter>(),
        LoadingContract.View {

    override fun layout() = R.layout.activity_loading

    override fun presenter() = LoadingPresenter()

    override fun onCreate() {
        Handler().postDelayed({
            finish(LogInActivity::class.java)
        }, 1000)
    }

}
