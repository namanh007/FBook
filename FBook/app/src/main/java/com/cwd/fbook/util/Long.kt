package com.cwd.fbook.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

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