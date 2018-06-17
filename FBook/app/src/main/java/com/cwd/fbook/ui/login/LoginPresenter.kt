package com.cwd.fbook.ui.login

import com.huy.source.MvpPresenter

/**
 * Created by tykud on 17/06/2018.
 */
class LoginPresenter : MvpPresenter<LoginContract.View>(), LoginContract.Presenter {

    override fun login(email: String, pass: String) {

        view?.notify(
                if(!email.isNullOrEmpty() || !pass.isNullOrEmpty())
                    "dang nhap thanh cong"
                else
                    "dang nhap that bai"
        )
    }


}