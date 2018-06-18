package com.huy.source

import android.content.Context
import com.cwd.fbook.R

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @LastEditor: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class ProcessDialog(context: Context) : BaseDialog(context) {

    override fun layout() = R.layout.dialog_process

    override fun theme() = R.style.DialogProcess
}