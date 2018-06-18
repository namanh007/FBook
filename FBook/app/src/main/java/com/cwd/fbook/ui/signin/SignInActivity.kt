package com.cwd.fbook.ui.signin

import android.view.View
import com.cwd.fbook.R
import com.huy.source.MvpActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Tykudo 2018-06-15
 *  @LastEditor: CWD Tykudo 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class SignInActivity : MvpActivity<SignInContract.View, SignInContract.Presenter>(), SignInContract.View {

    override fun layout() = R.layout.activity_login

    override fun presenter(): SignInContract.Presenter? = SignInPresenter()

    override fun onCreate() {
        btn_login.setOnClickListener(onViewClick)
    }

    override fun onViewClick(v: View) {
       presenter?.login(edt_name.text.toString(),edt_pass.text.toString())
    }



}