package com.cwd.fbook.data.api

import com.cwd.fbook.data.Key
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import javax.xml.transform.Result

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-24
 *  @Description: ...
 *  All Right Reserved.
 */
class ApiEndPoint {

    interface Login {
        @FormUrlEncoded
        @POST("signin.php")
        fun request(
                @Field(Key.USER_ID) userId: String,
                @Field(Key.PASSWORD) password: String
        ): Call<Result>
    }

    interface Register {
        @FormUrlEncoded
        @POST("signup.php")
        fun request(
                @Field(Key.USER_ID) userId: String,
                @Field(Key.PASSWORD) password: String,
                @Field(Key.FIRST_NAME) firstName: String,
                @Field(Key.LAST_NAME) lastName: String,
                @Field(Key.SEX) sex: Int,
                @Field(Key.BIRTH) birth: Int,
                @Field(Key.COUNTRY) country: String,
                @Field(Key.CITY) city: String
        ): Call<Result>
    }

    interface SendInvite {
        @FormUrlEncoded
        @POST("invite.php")
        fun request(@Field(Key.USER_ID) userId: String,
                    @Field(Key.INVITE_ID) inviteId: String)
                : Call<Result>
    }

    interface SearchUser {
        @FormUrlEncoded
        @POST("search.php")
        fun request(@Field(Key.SEARCH_KEY) username: String,
                    @Field(Key.FROM_RESULT) fromResult: Int)
                : Call<ResponseBody>
    }

    interface UploadUserPhoto {
        @Multipart
        @POST("upload_photo.php")
        fun request(
                @Part(Key.USER_ID) username: RequestBody,
                @Part file: MultipartBody.Part
        ): Call<Result>
    }

    interface UpdateUserPhoto {
        @FormUrlEncoded
        @POST("update_photo.php")
        fun request(@Field(Key.USER_ID) username: String,
                    @Field(Key.IMAGE_PATH) photoDisplay: String)
                : Call<ResponseBody>
    }
}