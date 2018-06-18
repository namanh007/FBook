package com.huy.source

import android.content.Intent
import android.support.annotation.IdRes
import android.support.annotation.NonNull
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @LastEditor: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
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

fun <T : View> AppCompatActivity.find(@IdRes resId: Int): Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(resId) }
}

fun <T : View> AppCompatActivity.bind(@IdRes resId: Int): T {
    @Suppress("UNCHECKED_CAST")
    return findViewById(resId)
}