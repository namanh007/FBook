package com.cwd.fbook.util

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.net.Uri
import android.provider.MediaStore
import android.provider.Settings
import android.speech.RecognizerIntent
import android.support.annotation.*
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Base64
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.cwd.fbook.R
import java.io.ByteArrayOutputStream
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
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
    if(currentFocus==null)
        return
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(currentFocus.windowToken, 0)
}

fun AppCompatActivity.launchFragment(@NonNull fragment: Fragment, frameId: Int, stackPopup: Boolean) {

    if(stackPopup) {

        val tag = fragment::class.java.simpleName
        supportFragmentManager.transaction { add(frameId, fragment, tag) }
        supportFragmentManager.transaction { addToBackStack(tag) }
    } else
        supportFragmentManager.transaction { add(frameId, fragment) }

}

fun AppCompatActivity.replaceFragment(@NonNull fragment: Fragment, frameId: Int) {
    supportFragmentManager.transaction { replace(frameId, fragment) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, @IdRes layoutRes: Int, stackAdding: Boolean) {
    val tag = fragment.javaClass.simpleName
    val f = supportFragmentManager.findFragmentByTag(tag)
    if(f != null)
        supportFragmentManager.popBackStackImmediate(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    val trans = supportFragmentManager.beginTransaction()
    trans.replace(layoutRes, fragment, fragment.javaClass.simpleName)
    if(stackAdding)
        trans.addToBackStack(fragment.javaClass.simpleName)
    trans.commit()
}

fun AppCompatActivity.navigate(_class: Class<*>) {
    startActivity(Intent(this, _class))
}

fun AppCompatActivity.finish(_class: Class<*>) {
    startActivity(Intent(this, _class))
    finish()
}

fun AppCompatActivity.toast(string: String) {
    Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.toast(@StringRes stringRes: Int) {
    Toast.makeText(this, stringRes, Toast.LENGTH_SHORT).show()
}

fun Context.version(): String {

    var version = ""
    try {

        val manager = packageManager
        val info = manager.getPackageInfo(packageName, 0)
        version = info.versionName
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }
    return version
}

fun Context.restartApp() {

    val intent = packageManager.getLaunchIntentForPackage(packageName)
    intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    startActivity(intent)
}

fun Context.keyHash() {

    try {
        var info: android.content.pm.PackageInfo? = null
        try {
            info = packageManager.getPackageInfo(
                    "com.cwd.demo",
                    android.content.pm.PackageManager.GET_SIGNATURES)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        for (signature in info!!.signatures) {
            val md = MessageDigest.getInstance("SHA")
            md.update(signature.toByteArray())
            Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
        }
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }

}

@SuppressLint("SupportAnnotationUsage")
@RequiresPermission(allOf = [(Manifest.permission.ACCESS_NETWORK_STATE), (Manifest.permission.ACCESS_WIFI_STATE)])
fun Context.networkConnected(): Boolean {

    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting
}

fun Context.screenWidth() : Int?{

    val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val dm = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(dm)
    return dm.heightPixels
}

fun Context.screenHeight(): Int? {

    val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val dm = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(dm)
    return dm.heightPixels
}

fun Context.statusBarHeight(): Int? {

    var result = 0
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0)
        result = resources.getDimensionPixelSize(resourceId)
    return result
}

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

internal fun FragmentManager.remove(tag: String,
                                    @AnimRes slideIn: Int = R.anim.enter_from_left,
                                    @AnimRes slideOut: Int = R.anim.exit_to_right) {
    this.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .remove(this.findFragmentByTag(tag))
            .commitNow()
}

internal fun FragmentManager.add(containerRes: Int,
                                 fragment: Fragment,
                                 tag: String,
                                 @AnimRes slideIn: Int = R.anim.enter_from_right,
                                 @AnimRes slideOut: Int = R.anim.exit_to_left) {

    this.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .add(containerRes, fragment, tag)
            .commit()
}

internal fun FragmentManager.transaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.enter_from_left,
            R.anim.exit_to_right
    )
    fragmentTransaction.func()
    fragmentTransaction.commit()
}

val IMAGE_REQUEST_CODE = 1004
val VOICE_REQUEST_CODE = 1005

val cameraIntent: Intent
    get() = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

val galleryIntent: Intent
    get() {
        val intent = Intent(Intent.ACTION_PICK)
        val directory = android.os.Environment
                .getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_PICTURES)
        val path = directory.path
        val data = Uri.parse(path)
        intent.setDataAndType(data, "image/*")
        return intent
    }

val voiceRecordIntent: Intent
    get() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speech")
        return intent
    }

val emailIntent: Intent
    get() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_APP_EMAIL)
        return intent
    }

val settingsIntent: Intent
    get() = Intent(Settings.ACTION_SETTINGS)