package com.cwd.fbook.ui.signin

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.cwd.fbook.ui.signin.model.UserModel
import com.cwd.fbook.util.isPassword
import com.huy.source.MvpPresenter
import org.json.JSONObject

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
                        else{

                        }
                    }

                    override fun onError(anError: ANError?) {
                        Log.d(SignInTag.ERROR,anError!!.message + anError!!.errorCode)
                    }

                })

    }


    override fun login(username: String?, password: String?) {

        //if(password.isPassword() && ...)
    }



}