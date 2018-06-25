package com.cwd.fbook.ui.register

import com.cwd.fbook.R
import com.cwd.fbook.ui.adapter.YearAdapter
import com.cwd.fbook.ui.model.Sex
import com.cwd.fbook.util.isPassword
import com.cwd.fbook.util.isPersonName
import com.huy.source.MvpPresenter
import java.io.File

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Tykudo 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class RegisterPresenter : MvpPresenter<RegisterContract.View>(),
        RegisterContract.Presenter {

    private var firstName: String? = null
    private var lastName: String? = null
    private var password: String? = null
    private var birth = 1950
    private var country : String? = null
    private var city : String? = null
    private var sex = 4

    override var yearAdt: YearAdapter? = null

    override fun register() {

    }

    override fun validateUserName(firstName: String?, lastName: String?) {

        var valid = true

        if(firstName.isPersonName()) {
            this.firstName = firstName
            view?.showFirstNameHint(0)
        } else {
            valid = false
            view?.showFirstNameHint(R.string.name_invalid)
        }

        if(lastName.isPersonName()) {
            this.lastName = lastName
            view?.showLastNameHint(0)
        } else {
            valid = false
            view?.showLastNameHint(R.string.name_invalid)
        }

        if(valid) view?.swipeNextView()
    }

    override fun attachSex(sex: Sex) {
        this.sex = sex.id
        if(yearAdt == null)
            yearAdt = YearAdapter()
        view?.swipeNextView()
    }

    override fun attachBirth() {
        this.birth = yearAdt?.get(yearAdt!!.selectedPosition)!!
        view?.swipeNextView()
    }

    override fun validatePassword(password: String?, retypePassword: String?) {

        if(password.isPassword() && retypePassword == password){

        }else{

        }
    }

    override fun validateImageFile(file: File?) {

    }


}