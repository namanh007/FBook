package com.cwd.fbook.ui.signup

import com.huy.source.MvpPresenter

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Tykudo 2018-06-15
 *  @LastEditor: CWD Tykudo 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
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