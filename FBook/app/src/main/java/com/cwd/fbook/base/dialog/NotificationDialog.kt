package com.huy.source

import android.content.Context
import android.support.annotation.StringRes
import android.widget.TextView
import com.cwd.fbook.R
import com.cwd.fbook.base.BaseDialog

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class NotificationDialog(context: Context) : BaseDialog(context) {

    override fun layout() = R.layout.dialog_notify

    override fun theme(): Nothing? = null

    private val txvMessage: TextView by find(R.id.dialog_TextView_Message)

    fun message(@StringRes stringRes: Int?) {
        txvMessage.setText(stringRes!!)
    }

    fun message(string: CharSequence?) {
        txvMessage.text = string!!
    }
    
}