package com.cwd.fbook.ui.login

import android.content.Context
import android.util.Log
import com.cwd.fbook.R
import com.cwd.fbook.data.api.ApiHelper
import com.cwd.fbook.data.api.response.RequestListener
import com.cwd.fbook.data.pref.PrefHelper
import com.cwd.fbook.ui.response.UserRes
import com.cwd.fbook.util.isPassword
import com.cwd.fbook.util.isPersonName
import com.cwd.fbook.util.parse
import com.google.gson.JsonObject
import com.huy.source.MvpPresenter
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


/**
 * Created by tykud on 17/06/2018.
 */
class LogInPresenter : MvpPresenter<LogInContract.View>(),
        LogInContract.Presenter {


    override fun validateLoginField(username: String?, password: String?) {

        if (username.isPersonName()) {
            //this.username = username
            view?.showUsername(0)
        } else {
            string(R.string._continue)
            view?.showUsername(R.string.name_invalid)
        }
        if (password.isPassword()) {
            //this.password = password
            view?.showPass(0)
        } else {
            view?.showPass(R.string.password_invalid)
        }
    }


    private fun login(username: String, password: String) {

        ApiHelper.instance.login(username, password, object : RequestListener {
            override fun onSuccess(data: JsonObject) {
                val user = data.parse(UserRes::class.java)

                if (user==null){

                }else{

                }
            }
        })
    }

}