package com.cwd.fbook.ui.login

import com.cwd.fbook.R
import com.cwd.fbook.data.api.ApiHelper
import com.cwd.fbook.data.api.response.RequestListener
import com.cwd.fbook.ui.response.UserRes
import com.cwd.fbook.util.isPassword
import com.cwd.fbook.util.isPersonName
import com.cwd.fbook.util.isUserName
import com.cwd.fbook.util.parse
import com.google.gson.JsonObject
import com.huy.source.MvpPresenter


/**
 * Created by tykud on 17/06/2018.
 */
class LogInPresenter : MvpPresenter<LogInContract.View>(),
        LogInContract.Presenter {


    override fun validateLoginField(username: String?, password: String?) {

        var valid = true
        if (username.isUserName()) {
            view?.showUsername(0)
        } else {
            view?.showUsername(R.string.name_invalid)
            valid = false
        }
        if (password.isPassword()) {
            view?.showPass(0)
            if (!valid) return
        } else {
            view?.showPass(R.string.password_invalid)
            return
        }

        login(username!!, password!!)


    }


    private fun login(username: String, password: String) {

        ApiHelper.instance.login(username, password, object : RequestListener {
            override fun onSuccess(data: JsonObject) {
                val user = data.parse(UserRes::class.java)

                if (user == null) {
                    view?.toast("Login fail")
                } else {
                    view?.toast(user.toString())
                }
            }
        })
    }

}