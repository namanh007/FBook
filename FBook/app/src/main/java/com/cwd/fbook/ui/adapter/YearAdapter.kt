package com.cwd.fbook.ui.adapter

import android.view.View
import com.cwd.fbook.R
import com.cwd.fbook.base.adapter.BaseAdapter
import com.cwd.fbook.base.adapter.SelectableAdapter
import com.cwd.fbook.util.currentYear

/**
 *  @Project: FBook
 *  @CreatedBy: Huy CWD 2018-06-23
 *  @Description: ...
 *  All Right Reserved.
 */
class YearAdapter : SelectableAdapter<Int>() {

    init {
        val list = mutableListOf<Int>()
        for(i in (currentYear - 65)..(currentYear - 5))
            list.add(i)
        selectedPosition = size() - 18
        set(list)
    }

    override fun defaultBindItem(holder: ViewHolder, item: Int, position: Int) {
        super.defaultBindItem(holder, item, position)
        holder.setText(item.toString())
    }


}


