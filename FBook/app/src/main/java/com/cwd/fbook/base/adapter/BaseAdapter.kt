package com.cwd.fbook.base.adapter

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.cwd.fbook.util.inflate

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-23
 *  @Description: ...
 *  All Right Reserved.
 */
abstract class BaseAdapter<M, in H : BaseViewHolder>
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    /**
     * [RecyclerView.Adapter] override
     */
    override fun getItemCount() = if(dataEmpty) 1 else dataList.size

    override fun getItemViewType(position: Int): Int {
        return if(dataEmpty) EMPTY else DEFAULT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            EMPTY -> {
                emptyViewHolder(parent.inflate(emptyItem()))
            }
            else -> {
                defaultViewHolder(parent.inflate(defaultItem()))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(dataEmpty) {
            emptyBindItem()
            return
        }
        val item = get(position)
        if(item != null)
            defaultBindItem(holder as H, item, position)
    }


    /**
     * Configure methods
     */
    interface OnItemSelectedListener<in M> {
        fun onItemSelected(item: M, position: Int)
    }

    var onItemSelectedListener: OnItemSelectedListener<M>? = null

    @LayoutRes
    protected abstract fun defaultItem(): Int

    protected abstract fun defaultViewHolder(view: View): BaseViewHolder

    protected abstract fun defaultBindItem(holder: H, item: M, position: Int)

    @LayoutRes
    protected fun emptyItem() = defaultItem()

    protected fun emptyViewHolder(view: View) = defaultViewHolder(view)

    protected fun emptyBindItem() {}


    /**
     * Data list handle
     */
    private var dataList = mutableListOf<M>()

    private var dataEmpty: Boolean = false
        get() = dataList.isEmpty()

    fun set(items: MutableList<M>) {
        dataList = items
        notifyDataSetChanged()
    }

    fun add(item: M?, position: Int = -1) {
        if(item == null) return
        val i = if(position == -1) dataList.size else position
        dataList.add(i, item)
        notifyItemInserted(i)
    }

    fun add(items: MutableList<M>?) {
        if(items == null || items.isEmpty()) return
        val size = size()
        dataList.addAll(items)
        notifyItemRangeInserted(size, size + items.size - 1)
    }

    fun edit(position: Int, item: M?) {
        if(item == null) return
        if(position !in 0 until size())
            add(item)
        else {
            dataList[position] = item
            notifyItemChanged(position)
        }
    }

    fun remove(item: M) {
        val index = dataList.indexOf(item)
        if(index != -1) return
        dataList.removeAt(index)
        notifyItemRemoved(index)
    }

    fun remove(position: Int) {
        if(position !in 0 until size()) return
        dataList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun clear() {
        if(dataList != null && dataList.isNotEmpty())
            dataList.clear()
    }

    fun size() = dataList.size

    fun get(position: Int): M? {
        return if(position in 0..dataList.size) dataList[position] else null
    }

    fun list(): MutableList<M> = dataList
}