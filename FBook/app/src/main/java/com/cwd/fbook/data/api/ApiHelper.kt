package com.cwd.fbook.data.api
import com.cwd.fbook.data.Key
import com.cwd.fbook.data.api.model.ApiMsg
import com.cwd.fbook.data.api.response.ApiResponse
import com.cwd.fbook.data.api.response.BodyResponse
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import javax.xml.transform.Result

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-24
 *  @Description: ...
 *  All Right Reserved.
 */
class ApiHelper {

    private val apiHeader = ApiHeader

    fun login(username: String, password: String, listener: ApiResponse) {
        val api = apiHeader.instance.create(ApiEndPoint.Login::class.java)
        val call = api.request(username, password)
    }

    fun register(username: String, password: String, firstName: String, lastName: String,
                 sex: Int, birth: Int, country: String, city: String,
                 listener: ApiResponse) {
        val api = apiHeader.instance.create(ApiEndPoint.Register::class.java)
        val call = api.request(username, password, firstName, lastName, sex, birth, country, city)

    }

    fun sendInvite(userId: String, inviteId: String, listener: ApiResponse) {
        val api = apiHeader.instance.create(ApiEndPoint.SendInvite::class.java)
        val call = api.request(userId, inviteId)
    }

    fun searchUser(searchKey: String, fromResult: Int, listener: ApiResponse) {
        val api = apiHeader.instance.create(ApiEndPoint.SearchUser::class.java)
        val call = api.request(searchKey, fromResult)
    }

    fun uploadUserPhoto(username: String, file: File, type: MediaType, listener: ApiResponse) {

        val description = RequestBody.create(okhttp3.MultipartBody.FORM, username)
        val requestBody = RequestBody.create(type, file)
        val filePart = MultipartBody.Part.createFormData(Key.PHOTO_DISPLAY, file.name, requestBody)
        val api = apiHeader.instance.create(ApiEndPoint.UploadUserPhoto::class.java)
        val call = api.request(description, filePart)
    }

    fun updateUserPhoto(username: String, photoDisplay: String, listener: ApiResponse) {
        val api = apiHeader.instance.create(ApiEndPoint.UpdateUserPhoto::class.java)
        val call = api.request(username, photoDisplay)
    }

    fun getImageUrl(userPhotoPath: String?): String? {
        if(userPhotoPath.isNullOrEmpty())
            return null
        return "http://${ApiHeader.HOST}/fbook/$userPhotoPath"
    }

    private fun addResponseCallBackListener(call: Call<ResponseBody>, listener: BodyResponse) {
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.isSuccessful) {
                    val body = response.body()!!.string().toString()
                    if(!body.isNullOrEmpty())
                        listener.onSuccess()
                    else
                        listener.onFailed()
                } else
                    listener.onFailed()
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                listener.onFailed()
            }
        })
    }

    private fun addResultCallBackListener(call: Call<ApiMsg>, listener: ApiResponse) {

        call.enqueue(object : Callback<ApiMsg> {
            override fun onResponse(call: Call<ApiMsg>?, response: Response<ApiMsg>?) {
                try {
                    val result = response!!.body()!!.result
                    val code = response.body()!!.code
                    val message = response.body()!!.message
                    listener.onSuccess(ApiMsg(result, code, message))
                } catch(ex: JSONException) {
                    ex.printStackTrace()
                    listener.onFailed()
                }
            }

            override fun onFailure(call: Call<ApiMsg>?, t: Throwable?) {
                listener.onFailed()
            }
        })
    }


}