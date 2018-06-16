package com.cwd.fbook.ui.dialog

import android.content.Context
import com.cwd.fbook.BaseDialog
import com.cwd.fbook.R

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
class ProcessDialog(context: Context) : BaseDialog(context) {

    override fun layout() = R.layout.dialog_process

    override fun theme() = R.style.DialogProcess
}