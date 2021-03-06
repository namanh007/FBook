package com.huy.source

import android.content.SharedPreferences

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @LastEditor: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
inline fun SharedPreferences.edit(block: SharedPreferences.Editor.() -> Unit) {

    val editor = edit()
    editor.block()
    editor.apply()
}