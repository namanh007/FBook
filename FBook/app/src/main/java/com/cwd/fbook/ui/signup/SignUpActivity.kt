package com.cwd.fbook.ui.signup

import android.view.View
import com.cwd.fbook.R
import com.huy.source.MvpActivity

/**
 * Created by tykud on 17/06/2018.
 */
class SignUpActivity : MvpActivity<SignUpContract.View,SignUpContract.Presenter>(), SignUpContract.View{

    override fun layout() = R.layout.activity_login

    override fun presenter(): SignUpContract.Presenter?  = SignUpPresenter()

    override fun onCreate() {

    }

    override fun onViewClick(v: View) {

    }

}
