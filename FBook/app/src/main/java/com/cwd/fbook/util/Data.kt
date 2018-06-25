package com.cwd.fbook.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

/**
 *  @Project: FBook
 *  @CreatedBy: Huy AGS 2018-06-23
 *  @Description: ...
 *  All Right Reserved.
 */
@Throws(ParseException::class)
fun Long.parse(): Date? {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return calendar.time
}

fun Long.toDateText(): String? {
    return SimpleDateFormat("MM-dd-yyyy").format(Date(this))
}

fun Long.toTimeText(): String? {
    return SimpleDateFormat("hh:mm a MM-dd-yyyy").format(Date(this))
}

fun Long.isCurrentDay(): Boolean? {

    val cal = Calendar.getInstance()
    cal.timeInMillis = this
    val deviceCal = Calendar.getInstance()
    deviceCal.time = Calendar.getInstance().time!!
    return (cal.get(Calendar.DAY_OF_MONTH) == deviceCal.get(Calendar.DAY_OF_MONTH)
            && cal.get(Calendar.MONTH) == deviceCal.get(Calendar.MONTH)
            && cal.get(Calendar.YEAR) == deviceCal.get(Calendar.YEAR))
}

fun String?.isEmail(): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String?.isPhone(): Boolean {
    return this!!.matches("^[0-9]{16}$".toRegex())
}

fun String?.isPersonName(): Boolean {
    return this!!.matches("[a-zA-Z ]+".toRegex()) && this!!.length in 1..24
}

fun String?.isPassword(): Boolean {
    return this!!.length in 6..24
}

fun HashMap<String, Any>.stringOf(key: String) : String{
    return get(key).toString()
}

fun HashMap<String, Any>.intOf(key: String) : Int{
    return get(key).toString().toInt()
}