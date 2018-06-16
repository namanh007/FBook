package com.cwd.fbook.util

import android.content.Intent
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast

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
fun Fragment.openCamera(requestCode: Int = IMAGE_REQUEST_CODE) {

    startActivityForResult(cameraIntent, requestCode)
}

fun Fragment.openGallery(requestCode: Int = IMAGE_REQUEST_CODE) {

    startActivityForResult(galleryIntent, requestCode)
}

fun Fragment.openSettings() {

    startActivityForResult(settingsIntent, 0)
}

fun Fragment.openEmail() {

    startActivity(emailIntent)
}

fun Fragment.openVoiceRecord() {

    startActivityForResult(voiceRecordIntent, VOICE_REQUEST_CODE)
}

fun Fragment.navigate(_class: Class<*>){

    startActivity(Intent(activity,_class))
}

fun Fragment.finish(_class: Class<*>){

    startActivity(Intent(activity,_class))
    activity?.finish()
}

fun Fragment.toast(message: CharSequence){

    Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
}

fun Fragment.hideKeyboard() {

    activity?.hideKeyboard()
}

fun <T : View> Fragment.find(@IdRes resId: Int): Lazy<T> {

    @Suppress("UNCHECKED_CAST")
    return lazy(LazyThreadSafetyMode.NONE) { view!!.findViewById<T>(resId) }
}

fun <T : View> Fragment.bind(@IdRes resId: Int): T {

    @Suppress("UNCHECKED_CAST")
    return view!!.findViewById(resId)
}