package com.cwd.fbook.ui.signup

import com.huy.source.MvpPresenter

/**
 * Created by tykud on 17/06/2018.
 */
class SignUpPresenter : MvpPresenter<SignUpContract.View>(), SignUpContract.Presenter{

    override fun signUp(email: String, pass: String) {
        view?.notify(
                if(!email.isNullOrEmpty() || !pass.isNullOrEmpty())
                    "dang nhap thanh cong"
                else
                    "dang nhap that bai"
        )
    }

}