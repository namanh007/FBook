package com.cwd.fbook.data.api

import com.cwd.fbook.data.Key
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-24
 *  @Description: ...
 *  All Right Reserved.
 */
interface ApiService {

    /*@FormUrlEncoded
    @POST("signin.php")
    fun login(
            @Field("username") username : String,
            @Field("password") password: String): Call<ResponseBody>*/
    //@FormUrlEncoded
    @POST("signin.php")
    fun login(@Body jsonObject : JsonObject): Call<JsonObject>


    @FormUrlEncoded
    @POST("signup.php")
    fun register(jsonObject : JsonObject): Call<JsonObject>


    @FormUrlEncoded
    @POST("invite.php")
    fun sendInvite(jsonObject : JsonObject): Call<JsonObject>


    @FormUrlEncoded
    @POST("search.php")
    fun searchUser(jsonObject : JsonObject): Call<JsonObject>


    @Multipart
    @POST("upload_photo.php")
    fun uploadUserPhoto(jsonObject : JsonObject): Call<JsonObject>


    @FormUrlEncoded
    @POST("update_photo.php")
    fun updateUserPhoto(jsonObject : JsonObject): Call<JsonObject>


}