package com.cwd.fbook.ui.login

import com.huy.source.MvpPresenterInt
import com.huy.source.MvpViewInt

/**
 * Created by tykud on 17/06/2018.
 */
interface LogInContract {

    interface View : MvpViewInt {

        fun showUsername(stringRes: Int)

        fun showPass(stringRes: Int)
    }


    interface Presenter : MvpPresenterInt<View> {

        fun validateLoginField(username: String?, password: String?)
    }

}