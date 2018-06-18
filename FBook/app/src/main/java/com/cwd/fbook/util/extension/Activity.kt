package com.huy.source

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.support.annotation.IdRes
import android.support.annotation.RequiresPermission
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.io.ByteArrayOutputStream

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @LastEditor: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
@SuppressLint("SupportAnnotationUsage")
@RequiresPermission(allOf = [(Manifest.permission.READ_EXTERNAL_STORAGE), (Manifest.permission.WRITE_EXTERNAL_STORAGE)])
fun Activity.openCamera(requestCode: Int = IMAGE_REQUEST_CODE) {
    startActivityForResult(cameraIntent, requestCode)
}

fun Activity.openGallery(requestCode: Int = IMAGE_REQUEST_CODE) {
    startActivityForResult(galleryIntent, requestCode)
}

fun Activity.openSettings() {
    startActivityForResult(settingsIntent, 0)
}

fun Activity.openEmail() {
    startActivity(emailIntent)
}

fun Activity.openVoiceRecord() {
    startActivityForResult(voiceRecordIntent, VOICE_REQUEST_CODE)
}

fun Activity.getImageUri(inImage: Bitmap): Uri {
    val bytes = ByteArrayOutputStream()
    inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
    val path = MediaStore.Images.Media.insertImage(this.contentResolver, inImage, "Title", null)
    return Uri.parse(path)
}

fun Activity.getRealPathFromURI(uri: Uri): String {
    val cursor = contentResolver.query(uri, null, null, null, null)
    cursor.moveToFirst()
    val idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
    return cursor.getString(idx)
}

fun Activity.hideKeyboard() {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(currentFocus.windowToken, 0)
}

fun <T : View> Activity.find(@IdRes resId: Int): Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(resId) }
}

fun <T : View> Activity.bind(@IdRes resId: Int): T {
    @Suppress("UNCHECKED_CAST")
    return findViewById(resId)
}