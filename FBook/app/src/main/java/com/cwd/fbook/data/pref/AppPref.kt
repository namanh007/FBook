package com.cwd.fbook.data.pref

import android.content.Context
import android.content.SharedPreferences
import com.cwd.fbook.App

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class AppPref private constructor() {

    private lateinit var shared: SharedPreferences
    private var editor: SharedPreferences.Editor? = null

    private fun init() {
        shared = App.instance.getSharedPreferences(SHARED, Context.MODE_PRIVATE)!!
    }

    val accountId: String
        get() = getKey(ID)

    val accountName: String
        get() = "${getKey(FIRST_NAME)} ${getKey(LAST_NAME)}"

    val account: Account
        get() {
            val a = Account()
            a.id = getKey(ID)
            a.photoDisplay = getKey(PHOTO_DISPLAY)
            a.firstName = getKey(FIRST_NAME)
            a.lastName = getKey(LAST_NAME)
            a.sex = getKey(SEX)
            a.email = getKey(EMAIL)
            return a
        }

    val country: String
        get() = shared.getString(COUNTRY, "")

    val location: String
        get() = shared.getString(PROVINCE, "")

    fun saveCountry(id: String) {
        edit()
        editor?.putString(COUNTRY, id)
        editor?.apply()
    }

    fun saveProvince(id: String) {
        edit()
        editor?.putString(PROVINCE, id)
        editor?.apply()
    }

    fun edit() {
        editor = shared.edit()
    }

    fun commit() {
        editor?.apply()
        editor = null
    }

    private fun getKey(key: String): String {
        return shared.getString(key, "")
    }

    private fun getLong(key: String): Long {
        return shared.getLong(key, 0)
    }

    private fun putKey(key: String, value: String) {
        editor?.putString(key, value)
    }

    private fun putLong(key: String, value: Long) {
        editor?.putLong(key, value)
    }

    companion object {

        const val SHARED = "shared_user"
        const val ID = "id"
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
        const val EMAIL = "email"
        const val SEX = "sex"
        const val PHOTO_DISPLAY = "photo_display"
        const val COUNTRY = "country"
        const val PROVINCE = "province"

        @Volatile
        private var sInstance: AppPref? = null

        @Synchronized
        fun getInstance(): AppPref {
            var tmp = sInstance
            if (tmp == null) {
                synchronized(this) {
                    tmp = sInstance
                    if (tmp == null) {
                        tmp = AppPref()
                        tmp!!.init()
                        sInstance = tmp
                    }
                }
            }
            return tmp!!
        }
    }
}