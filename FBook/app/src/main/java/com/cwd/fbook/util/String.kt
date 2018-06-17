package com.cwd.fbook.util

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
fun String.isEmail() : Boolean {

    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isPhone() : Boolean{

    return matches("^[0-9]{16}$".toRegex())
}

fun String.isName() : Boolean{

    return matches("[a-zA-Z ]+".toRegex())
}