package com.cwd.fbook.data.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-24
 *  @Description: ...
 *  All Right Reserved.
 */
class ApiHeader private constructor() {

    private object ApiService {
        private val gson = GsonBuilder().setLenient().create()!!
        val INSTANCE = Retrofit.Builder().baseUrl("http://$HOST/fbbok/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()!!
    }

    companion object {
        val instance: Retrofit by lazy { ApiService.INSTANCE }
        const val HOST = "192.168.137.1"
        const val PORT = "8080"
    }

}