package com.cwd.fbook.ui.signin

import com.huy.source.MvpPresenter

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Tykudo 2018-06-15
 *  @LastEditor: CWD Tykudo 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class SignInPresenter : MvpPresenter<SignInContract.View>(), SignInContract.Presenter {

    override fun login(email: String, pass: String) {

        view?.notify(
                if(!email.isNullOrEmpty() || !pass.isNullOrEmpty())
                    "dang nhap thanh cong"
                else
                    "dang nhap that bai"
        )
    }


}