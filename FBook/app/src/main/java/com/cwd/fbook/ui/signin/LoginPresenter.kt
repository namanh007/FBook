package com.cwd.fbook.ui.signin

import android.util.Log
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.cwd.fbook.R
import com.cwd.fbook.ui.login.LoginActivity
import com.cwd.fbook.ui.signin.model.UserModel
import com.huy.source.MvpPresenter
import org.json.JSONArray
import org.json.JSONObject
import kotlin.math.absoluteValue
import kotlin.math.sign

/**
 * Created by tykud on 17/06/2018.
 */
class LoginPresenter : MvpPresenter<LoginContract.View>(), LoginContract.Presenter{
    override fun checkLogin() {

    }


    override fun postData(user: UserModel) {
        AndroidNetworking.post("http://localhost:8080/fbook/signin.php")
                .addBodyParameter(user) // posting java object
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener{
                    override fun onResponse(response: JSONObject?) {
                        if(response!!.get("code")==200)
                            Log.d(SignInTag.LOGIN, response.get("message").toString())
                        if(response!!.get("code")==999)
                            Log.d(SignInTag.ERROR, response.get("message").toString())

                        if(response!!.get("code")==101)
                            Log.d(SignInTag.ERROR, response.get("message").toString())

                        if(response!!.get("code")==102)
                            Log.d(SignInTag.ERROR, response.get("message").toString())
                    }

                    override fun onError(anError: ANError?) {
                        Log.d(SignInTag.ERROR,anError!!.message + anError!!.errorCode)
                    }

                })

    }


    override fun login(user: UserModel) {
        view?.notify(
                if(!user.userId.isNullOrEmpty() || !user.passWord.isNullOrEmpty())
                    "dang nhap thanh cong"
                else
                    "dang nhap that bai"
        )
    }



}