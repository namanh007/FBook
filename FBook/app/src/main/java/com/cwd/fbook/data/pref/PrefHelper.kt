package com.cwd.fbook.data.pref

import android.content.Context
import android.content.SharedPreferences
import com.cwd.fbook.App
import com.cwd.fbook.SHARED_PREF_NAME

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class PrefHelper private constructor() {

    private val sharedPref =
            App.instance.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    private var sharedEditor: SharedPreferences.Editor? = null

    companion object {
        val instance: PrefHelper by lazy { PrefHelper() }
    }

    fun intOf(key: String, defaultValue: Int = -1): Int {
        return try {
            sharedPref.getInt(key, defaultValue)
        } catch (e: ClassCastException) {
            sharedPref.edit().clear()
            -1
        }
    }

    fun stringOf(key: String, defaultValue: String? = null): String? {
        return try {
            sharedPref.getString(key, defaultValue)
        } catch (e: ClassCastException) {
            sharedPref.edit().clear()
            null
        }

    }

    fun booleanOf(key: String): Boolean = sharedPref.getBoolean(key, false)

    fun stringSetOf(key: String): Set<String>? = sharedPref.getStringSet(key, null)

    private fun commit() {
        sharedEditor?.apply()
        sharedEditor = null
    }

    fun edit(let: SharedPreferences.Editor.() -> Unit) {
        sharedEditor = sharedPref.edit()
        sharedEditor?.let()
        commit()
    }

    fun clear() {
        sharedEditor = sharedPref.edit()
        sharedEditor?.clear()
        commit()
    }

}




