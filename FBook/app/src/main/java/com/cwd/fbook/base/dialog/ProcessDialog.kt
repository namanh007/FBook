package com.huy.source

import android.content.Context
import com.cwd.fbook.R
import com.cwd.fbook.base.BaseDialog

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class ProcessDialog(context: Context) : BaseDialog(context) {

    override fun layout() = R.layout.dialog_process

    override fun theme() = R.style.DialogProcess
}