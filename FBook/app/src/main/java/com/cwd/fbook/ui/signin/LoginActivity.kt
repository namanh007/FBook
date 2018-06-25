package com.cwd.fbook.ui.signin

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
class LogInActivity : MvpActivity<LoginContract.View, LoginContract.Presenter>(), LoginContract.View {

    override fun layout() = R.layout.activity_login

    override fun presenter(): LoginContract.Presenter? = LoginPresenter()

    override fun onCreate() {
        addOnClick(login_view_login,login_view_register)
    }

    override fun onViewClick(v: View) {
        when(v){
            login_view_login -> {
                presenter?.login(login_inputView_userName.text,login_inputView_password.text)
            }
            login_view_register -> {
                navigate(RegisterActivity::class.java)
            }
        }
    }



}