package com.huy.source

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.SystemClock
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cwd.fbook.util.hideKeyboard
import java.io.IOException

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
abstract class BaseFragment : Fragment(), BaseView {

    private var lastClickTime: Long = 0

    protected val clickListener = View.OnClickListener { v ->
        if(SystemClock.elapsedRealtime() - lastClickTime > 360) {
            hideKeyboard()
            onViewClick(v)
        }
        lastClickTime = SystemClock.elapsedRealtime()
    }

    abstract fun getLayoutId(): Int

    protected open fun onViewClick(v: View) {
    }

    protected open fun onViewCreated() {
    }

    open fun onBackPressed() {
        (activity as? BaseActivity)?.onBackClick()
    }

    @Throws(RuntimeException::class, IOException::class)
    protected open fun onReceivedDataResult(requestCode: Int, data: Intent) {
    }

    protected open fun onReceivedPermissionResult(requestCode: Int) {
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setOnTouchListener { _, _ -> true }
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

    fun <T : View> find(@IdRes resId: Int): Lazy<T> {

        @Suppress("UNCHECKED_CAST")
        return lazy(LazyThreadSafetyMode.NONE) { view!!.findViewById<T>(resId) }
    }

    fun <T : View> bind(@IdRes resId: Int): T {

        @Suppress("UNCHECKED_CAST")
        return view!!.findViewById(resId)
    }
}