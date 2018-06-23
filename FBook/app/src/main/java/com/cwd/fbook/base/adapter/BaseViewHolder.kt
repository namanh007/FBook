package com.cwd.fbook.base.adapter

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 *  @Project: FBook
 *  @CreatedBy: Huy AGS 2018-06-23
 *  @Description: ...
 *  All Right Reserved.
 */
abstract class BaseViewHolder(view : View) : RecyclerView.ViewHolder(view){

    fun setOnItemClickListener(onClickListener: View.OnClickListener){
        itemView.setOnClickListener(onClickListener)
    }

}