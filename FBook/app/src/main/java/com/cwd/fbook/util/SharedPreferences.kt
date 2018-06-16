package com.cwd.fbook.util

import android.content.SharedPreferences

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
inline fun SharedPreferences.edit(block: SharedPreferences.Editor.() -> Unit) {

    val editor = edit()
    editor.block()
    editor.apply()
}