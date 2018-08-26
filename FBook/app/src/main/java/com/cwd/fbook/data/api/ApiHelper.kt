package com.cwd.fbook.data.api

import com.cwd.fbook.SERVICE
import com.cwd.fbook.data.Key
import com.cwd.fbook.data.api.response.RequestListener
import com.google.gson.JsonObject
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.*

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-24
 *  @Description: ...
 *  All Right Reserved.
 */
class ApiHelper {

    companion object {
        val instance: ApiHelper by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            ApiHelper()
        }
    }

    private val mService: ApiService = Retrofit.Builder()
            .baseUrl(SERVICE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    var queue: Queue<Int> = LinkedList<Int>()


    fun login(username: String, password: String, listener: RequestListener) {

        val parameter = buildParam {
            push("username", username)
            push("password", password)
        }
        mService.login(parameter).doRequest(listener)
    }


    fun register(username: String, password: String, firstName: String, lastName: String,
                 sex: Int, birth: Int, country: String, city: String,
                 listener: RequestListener) {

        val parameter = buildParam {
            push("username", username)
            push("password", password)
            push("firstName", firstName)
            push("lastName", lastName)
            push("lastName", birth)
            push("password", password)
        }
        mService.register(parameter).doRequest(listener)
    }



    private fun Call<JsonObject>.doRequest(listener: RequestListener) {
        this.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                val data = response?.body() ?: return
                listener.onSuccess(data)
            }
        })
    }

    private fun buildParam(void: JsonObject.() -> Unit?): JsonObject {
        val body = JsonObject()
        body.void()
        return body
    }

    private fun JsonObject.push(key: String, value: String?) {
        if (value != null)
            addProperty(key, value)
    }

    private fun JsonObject.push(key: String, value: Int?) {
        if (value != null)
            addProperty(key, value)
    }

}