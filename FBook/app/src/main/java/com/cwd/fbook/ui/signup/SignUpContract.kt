package com.cwd.fbook.ui.signup

import com.cwd.fbook.app.mvp.MvpViewInt
import com.huy.source.MvpPresenterInt

/**
 * Created by tykud on 17/06/2018.
 */
interface SignUpContract{

    interface View : MvpViewInt{


    }

    interface Presenter : MvpPresenterInt<View> {


        fun signUp(email : String,pass : String)
    }
}