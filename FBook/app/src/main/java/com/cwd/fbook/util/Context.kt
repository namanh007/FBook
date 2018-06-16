package com.cwd.fbook.util

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.support.annotation.RequiresPermission
import android.util.Base64
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

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
fun Context.version(): String {

    var version = ""

    try {

        val manager = packageManager
        val info = manager.getPackageInfo(packageName, 0)
        version = info.versionName
    } catch (e: android.content.pm.PackageManager.NameNotFoundException) {

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
        } catch (e: android.content.pm.PackageManager.NameNotFoundException) {

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
    if (resourceId > 0) {
        result = resources.getDimensionPixelSize(resourceId)
    }
    return result
}