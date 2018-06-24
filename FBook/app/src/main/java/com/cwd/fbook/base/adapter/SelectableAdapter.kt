package com.cwd.fbook.base.adapter

import android.view.View
import com.cwd.fbook.R
import com.cwd.fbook.util.color
import com.cwd.fbook.util.textView

/**
 *  @Project: FBook
 *  @CreatedBy: Huy CWD 2018-06-24
 *  @Description: ...
 *  All Right Reserved.
 */
abstract class SelectableAdapter<M> : BaseAdapter<M, SelectableAdapter.ViewHolder>() {

    var selectedPosition = 0

    override fun defaultItem() = R.layout.item_selectable

    override fun defaultViewHolder(view: View) = ViewHolder(view)

    override fun defaultBindItem(holder: ViewHolder, item: M, position: Int) {
        holder.setState(position == selectedPosition)
        holder.setOnItemClickListener(View.OnClickListener {
            if(position != selectedPosition) {
                val tempPos = selectedPosition
                selectedPosition = position
                notifyItemChanged(position)
                notifyItemChanged(tempPos)
            }
        })
    }

    class ViewHolder(view: View) : BaseViewHolder(view) {

        private val textView = textView(R.id.itemYear_textView)

        fun setText(text: String) {
            textView.text = text
        }

        fun setState(selected: Boolean) {
            textView.color(if(selected) R.color.colorPrimary else android.R.color.darker_gray)
        }
    }
}