package com.cwd.fbook.util

import android.widget.ImageView
import com.bumptech.glide.Glide

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
internal fun ImageView.load(url: String) {

    Glide.with(this.context).load(url).into(this)
}