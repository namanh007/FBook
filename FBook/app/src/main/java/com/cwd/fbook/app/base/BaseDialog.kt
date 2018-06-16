package com.cwd.fbook

import android.content.Context
import android.content.DialogInterface
import android.support.annotation.*
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView

/**
 **************************************************************************************************
 * 
 *  @Project: FBook
 *  @CreatedBy: Huy AgilSun Quoc Vu 2018-06-15
 *  @LastEditor: Huy AgilSun Quoc Vu 2018-06-15
 *  @Description: ...
 *
 *                                      All Right Reserved.
 *
 **************************************************************************************************
 */
abstract class BaseDialog{

    private var dialog: AlertDialog
    private var dialogView: View

    @LayoutRes
    protected abstract fun layout(): Int

    protected abstract fun theme(): Int?

    constructor(context: Context) {

        dialogView = LayoutInflater.from(context).inflate(layout(), null)
        val builder = if(theme() != null)
            AlertDialog.Builder(context, theme()!!)
        else
            AlertDialog.Builder(context)
        builder.setView(dialogView)
        dialog = builder.create()
        dialog.setOnDismissListener { onDismiss() }
    }

    fun title(@StringRes stringRes: Int) {
        val txvTitle: TextView by find(R.id.dialog_TextView_Title)
        txvTitle.setText(stringRes)
    }

    fun title(title: CharSequence) {
        val txvTitle: TextView by find(R.id.dialog_TextView_Title)
        txvTitle.text = title
    }

    fun onShowListener(listener: DialogInterface.OnShowListener) {
        dialog.setOnShowListener(listener)
    }

    fun onDismissListener(listener: DialogInterface.OnDismissListener) {
        dialog.setOnDismissListener(listener)
    }

    fun cancelOnOutTouch(value: Boolean) {
        dialog.setCanceledOnTouchOutside(value)
    }

    fun show() {
        dialog.show()
        onShow()
    }

    fun dismiss() {
        dialog.dismiss()
        onDismiss()
    }

    fun onShow() {
    }

    fun onDismiss() {
    }

    fun <T : View> find(@IdRes resId: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) { dialogView.findViewById<T>(resId) }
    }

    fun <T : View> bind(@IdRes resId: Int): T {
        return dialogView.findViewById(resId)
    }
}



