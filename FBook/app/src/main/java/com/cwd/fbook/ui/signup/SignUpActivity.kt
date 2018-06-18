package com.cwd.fbook.ui.signup

import android.view.View
import com.cwd.fbook.R
import com.huy.source.MvpActivity

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Tykudo 2018-06-15
 *  @LastEditor: CWD Tykudo 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class SignUpActivity : MvpActivity<SignUpContract.View,SignUpContract.Presenter>(), SignUpContract.View{

    override fun layout() = R.layout.activity_login

    override fun presenter(): SignUpContract.Presenter?  = SignUpPresenter()

    override fun onCreate() {

    }

    override fun onViewClick(v: View) {

    }

}
