package com.cwd.fbook.ui.login

import android.view.View
import com.androidnetworking.AndroidNetworking
import com.cwd.fbook.R
import com.cwd.fbook.ui.signin.LoginContract
import com.cwd.fbook.ui.signin.LoginPresenter
import com.huy.source.MvpActivity
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient

/**
 * Created by tykud on 17/06/2018.
 */
class LoginActivity : MvpActivity<LoginContract.View, LoginContract.Presenter>(), LoginContract.View {

    override fun layout() = R.layout.activity_login

    override fun presenter(): LoginContract.Presenter? = LoginPresenter()

    override fun onCreate() {
        btn_login.setOnClickListener(onViewClick)
        AndroidNetworking.initialize(getApplicationContext());

    }

    override fun onViewClick(v: View) {
       //presenter?.login(edt_user_id.text.toString(),edt_pass.text.toString())
    }



}