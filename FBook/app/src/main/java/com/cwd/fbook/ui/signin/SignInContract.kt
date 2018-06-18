package com.cwd.fbook.ui.signin

import com.huy.source.MvpPresenterInt
import com.huy.source.MvpViewInt

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Tykudo 2018-06-15
 *  @LastEditor: CWD Tykudo 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
interface SignInContract{

    interface View : MvpViewInt {


    }

    interface Presenter : MvpPresenterInt<View>{

        fun login(email : String, pass : String)
    }
}