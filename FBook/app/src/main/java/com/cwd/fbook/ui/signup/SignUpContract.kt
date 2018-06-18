package com.cwd.fbook.ui.signup

import com.huy.source.MvpPresenterInt
import com.huy.source.MvpViewInt

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Tykudo 2018-06-15
 *  @LastEditor: CWD Tykudo 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
interface SignUpContract{

    interface View : MvpViewInt {


    }

    interface Presenter : MvpPresenterInt<View> {


        fun signUp(email : String,pass : String)
    }
}