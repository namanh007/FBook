package com.huy.source

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @LastEditor: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
internal fun ImageView.load(url: String) {
    Glide.with(this.context).load(url).into(this)
}