package com.cwd.fbook.ui.login

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.cwd.fbook.R
import com.cwd.fbook.ui.register.RegisterActivity
import com.cwd.fbook.util.navigate
import com.huy.source.MvpActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Tykudo 2018-06-15
 *  @LastEditor: CWD Tykudo 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class LogInActivity : MvpActivity<LogInContract.View, LogInContract.Presenter>(), LogInContract.View {

    override fun layout() = R.layout.activity_login

    override fun presenter(): LogInContract.Presenter? = LogInPresenter()

    override fun onCreate() {
       addOnClick(login_view_login, login_view_register)
    }

    override fun onViewClick(v: View) {
       when (v) {
            login_view_login -> {
                presenter?.validateLoginField(login_inputView_userName.text,login_inputView_password.text)
            }
            login_view_register -> {
                navigate(RegisterActivity::class.java)
            }
        }
    }

    override fun showUsername(stringRes: Int) {

    }

    override fun showPass(stringRes: Int) {

    }


}