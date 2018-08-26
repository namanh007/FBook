package com.cwd.fbook.data.pref

import com.cwd.fbook.data.define.User
import com.cwd.fbook.exception.UnknownUserException

object UserPref {

    val pref: PrefHelper get() = PrefHelper.instance

    val userId: String
        get() {
            val id = pref.stringOf(User.ID) ?: throw UnknownUserException()
            return id!!
        }

    val fullName: String
        get() {
            val firtName = pref.stringOf(User.FIRST_NAME) ?: throw UnknownUserException()
            val lastName = pref.stringOf(User.FIRST_NAME) ?: throw UnknownUserException()
            return "$firtName $lastName"
        }

    val account: Account
        get() {
            val a = Account()
            a.id = pref.stringOf(User.ID) ?: throw UnknownUserException()
            a.photoDisplay = pref.stringOf(User.PHOTO_DISPLAY)
            a.firstName = pref.stringOf(User.FIRST_NAME) ?: throw UnknownUserException()
            a.lastName = pref.stringOf(User.LAST_NAME)
            a.sex = pref.stringOf(User.SEX) ?: throw UnknownUserException()
            a.email = pref.stringOf(User.EMAIL) ?: throw UnknownUserException()
            return a
        }

    val country: String?
        get() = pref.stringOf(User.COUNTRY, null)

    val province: String?
        get() = pref.stringOf(User.PROVINCE, null)

    fun saveLocation(country: String,province: String) {
        pref.edit {
            putString(User.COUNTRY,country)
            putString(User.PROVINCE,province)
        }
    }


}