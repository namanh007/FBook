package com.cwd.fbook.ui.login

import com.cwd.fbook.app.mvp.MvpViewInt
import com.huy.source.MvpPresenterInt

/**
 * Created by tykud on 17/06/2018.
 */
interface LoginContract{

    interface View : MvpViewInt{


    }

    interface Presenter : MvpPresenterInt<View>{

        fun login(email : String, pass : String)
    }
}