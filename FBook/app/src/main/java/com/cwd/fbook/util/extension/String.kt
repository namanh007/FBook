package com.huy.source

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @LastEditor: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
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