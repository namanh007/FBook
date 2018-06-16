package com.cwd.fbook.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.MalformedJsonException
import com.cwd.fbook.User
import org.json.JSONException

/**
 **************************************************************************************************
 * 
 *  @Project: FBook
 *  @CreatedBy: Huy AgilSun Quoc Vu 2018-06-14
 *  @LastEditor: Huy AgilSun Quoc Vu 2018-06-14
 *  @Description: ...
 *
 *                                      All Right Reserved.
 *
 **************************************************************************************************
 */
@Throws(JSONException::class, MalformedJsonException::class)
fun String.hashMapList(): MutableList<HashMap<String, Any?>> {

    val type = object : TypeToken<MutableList<HashMap<String, Any?>>>() {}.type
    return Gson().fromJson<MutableList<HashMap<String, Any?>>>(this, type)
}

@Throws(JSONException::class, MalformedJsonException::class)
fun String.hashMap(): HashMap<String, Any?> {

    val type = object : TypeToken<HashMap<String, Any?>>() {}.type
    return Gson().fromJson<HashMap<String, Any?>>(this, type)
}

@Throws(JSONException::class, MalformedJsonException::class)
fun String.mapList(): MutableList<Map<String, Any?>> {

    val type = object : TypeToken<MutableList<Map<String, Any?>>>() {}.type
    return Gson().fromJson<MutableList<Map<String, Any?>>>(this, type)
}

@Throws(JSONException::class, MalformedJsonException::class)
fun String.map(): Map<String, Any?> {

    val type = object : TypeToken<Map<String, Any?>>() {}.type
    return Gson().fromJson<Map<String, Any?>>(this, type)
}

@Throws(JSONException::class, MalformedJsonException::class)
fun String.mutableMapList(): MutableList<MutableMap<String, Any?>> {

    val type = object : TypeToken<MutableList<Map<String, Any?>>>() {}.type
    return Gson().fromJson<MutableList<MutableMap<String, Any?>>>(this, type)
}

@Throws(JSONException::class, MalformedJsonException::class)
fun String.mutableMap(): MutableMap<String, Any?> {

    val type = object : TypeToken<MutableMap<String, Any?>>() {}.type
    return Gson().fromJson<MutableMap<String, Any?>>(this, type)
}

@Throws(JSONException::class, MalformedJsonException::class)
fun String.userList(): MutableList<User?> {

    val type = object : TypeToken<MutableList<User?>>() {}.type
    return Gson().fromJson<MutableList<User?>>(this, type)
}

@Throws(JSONException::class, MalformedJsonException::class)
fun String.user(): User? {

    val type = object : TypeToken<User?>() {}.type
    return Gson().fromJson(this, type)
}

@Throws(JSONException::class, MalformedJsonException::class)
fun String.anyList(): MutableList<Any?> {

    val type = object : TypeToken<MutableList<Any?>>() {}.type
    return Gson().fromJson<MutableList<Any?>>(this, type)
}

@Throws(JSONException::class, MalformedJsonException::class)
fun String.any(): Any? {

    val type = object : TypeToken<Any?>() {}.type
    return Gson().fromJson(this, type)
}

@Throws(JSONException::class, MalformedJsonException::class)
fun <T : Any> String.parse(): T {

    return Gson().fromJson<T>(this, object : TypeToken<T>() {}.type)
}

fun String.isEmail() : Boolean {

    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isPhone() : Boolean{

    return matches("^[0-9]{16}$".toRegex())
}

fun String.isName() : Boolean{

    return matches("[a-zA-Z ]+".toRegex())
}