package com.cwd.fbook.ui.login

import com.huy.source.MvpPresenterInt
import com.huy.source.MvpViewInt

/**
 * Created by tykud on 17/06/2018.
 */
interface LogInContract{

    interface View : MvpViewInt {


    }

    interface Presenter : MvpPresenterInt<View>{

        fun login(username : String?, password : String?)

        fun checkLogin()
    }
}