package com.cwd.fbook.ui.signin

import com.cwd.fbook.ui.signin.model.UserModel
import com.huy.source.MvpPresenterInt
import com.huy.source.MvpViewInt

/**
 * Created by tykud on 17/06/2018.
 */
interface LoginContract{

    interface View : MvpViewInt {


    }

    interface Presenter : MvpPresenterInt<View>{

        fun login(username : String?, password : String?)
        fun checkLogin()
        fun postData(user: UserModel)
    }
}