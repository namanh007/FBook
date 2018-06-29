package com.cwd.fbook.base

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.cwd.fbook.util.hideKeyboard
import com.huy.source.NotificationDialog
import com.huy.source.ProcessDialog

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
abstract class BaseActivity : AppCompatActivity(), BaseView {

    @LayoutRes
    protected abstract fun layout(): Int

    private lateinit var process: ProcessDialog

    protected val click = View.OnClickListener { v ->
        hideKeyboard()
        onViewClick(v)
    }

    protected open fun onViewClick(v: View) {
    }

    protected abstract fun onCreate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout())
        process = ProcessDialog(this)
    }

    protected open fun onReceivedDataResult(requestCode: Int, data: Intent) {
    }

    protected open fun onReceivedPermissionResult(requestCode: Int) {
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && data != null)
            onReceivedDataResult(requestCode, data)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            onReceivedPermissionResult(requestCode)
    }

    override fun onBackPressed() {
        val fm = supportFragmentManager
        val stackCount = fm.backStackEntryCount
        if(stackCount > 0)
            (fm.fragments[fm.fragments.size - 1] as? BaseFragment)?.onBackPressed()
        else
            super.onBackPressed()
    }

    fun onBackClick() {
        super.onBackPressed()
    }

    fun addOnClick(vararg views : View){
        for(v in views)
            v.setOnClickListener(click)
    }

    override fun notify(charSequence: CharSequence) {
        val dialog = NotificationDialog(this)
        dialog.message(charSequence)
        dialog.show()
    }

    override fun notify(stringRes: Int) {
        val dialog = NotificationDialog(this)
        dialog.message(stringRes)
        dialog.show()
    }

    override fun toast(charSequence: CharSequence) {
        Toast.makeText(this, charSequence, Toast.LENGTH_SHORT).show()
    }

    override fun toast(stringRes: Int) {
        Toast.makeText(this, stringRes, Toast.LENGTH_SHORT).show()
    }

    override fun showProcessView() {
        process.show()
    }

    override fun hideProcessView() {
        process.dismiss()
    }

    fun <T : View> find(@IdRes resId: Int): Lazy<T> {

        @Suppress("UNCHECKED_CAST")
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(resId) }
    }

    fun <T : View> bind(@IdRes resId: Int): T {

        @Suppress("UNCHECKED_CAST")
        return findViewById(resId)
    }
}