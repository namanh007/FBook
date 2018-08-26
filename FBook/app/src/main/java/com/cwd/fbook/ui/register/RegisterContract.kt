package com.cwd.fbook.ui.register

import com.cwd.fbook.ui.adapter.YearAdapter
import com.cwd.fbook.data.define.Sex
import com.huy.source.MvpPresenterInt
import com.huy.source.MvpViewInt
import java.io.File

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Tykudo 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
interface RegisterContract {

    interface View : MvpViewInt {

        fun swipeNextView()

        fun showFirstNameHint(stringRes : Int)

        fun showLastNameHint(stringRes : Int)

        fun showPasswordHint(stringRes : Int)

        fun showRetypePasswordHint(stringRes : Int)
    }

    interface Presenter : MvpPresenterInt<View> {

        var yearAdt : YearAdapter?

        fun register()

        fun validateUserName(firstName: String?, lastName: String?)

        fun attachSex(sex: Sex)

        fun attachBirth()

        fun validatePassword(password: String?, retypePassword: String?)

        fun validateImageFile(file: File?)


    }
}