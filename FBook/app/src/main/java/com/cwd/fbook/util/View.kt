package com.cwd.fbook.util

import android.net.Uri
import android.support.annotation.*
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import com.bumptech.glide.Glide
import com.cwd.fbook.R
import com.cwd.fbook.view.SliderView
import kotlinx.android.synthetic.main.activity_register.*

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
fun Button.color(@ColorRes colorRes: Int) {
    setTextColor(ContextCompat.getColor(context, colorRes))
}

fun EditText.getInput() = this.text.toString().trim()

fun ImageView.load(url: String, cache: Boolean = false) {
    Glide.with(context).load(url).into(this)
}

fun ImageView.load(uri: Uri) {
    Glide.with(context).load(uri).into(this)
}

fun RadioGroup.checkedButton(): View? {
    for(i in 0 until this.childCount) {
        val v = this.getChildAt(i)
        if(v is RadioButton && v.isChecked)
            return v
    }
    return null
}

fun RecyclerView.setLinearAdapter(adt: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null, reverseLayout: Boolean = false) {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, reverseLayout)
    this.adapter = adt
}

fun RecyclerView.setHorizontalAdapter(adt: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null, reverseLayout: Boolean = false) {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, reverseLayout)
    this.adapter = adt
}

fun RecyclerView.setGridAdapter(spanCount: Int = 2, adt: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null, orientation: Int = LinearLayoutManager.VERTICAL, reverseLayout: Boolean = false) {
    layoutManager = GridLayoutManager(context, spanCount, orientation, reverseLayout)
    this.adapter = adt
}

fun RecyclerView.ViewHolder.view(@IdRes idRes: Int): View {
    return itemView.findViewById(idRes)
}

fun RecyclerView.ViewHolder.button(@IdRes idRes: Int): Button {
    return itemView.findViewById(idRes)
}

fun RecyclerView.ViewHolder.textView(@IdRes idRes: Int): TextView {
    return itemView.findViewById(idRes)
}

fun RecyclerView.ViewHolder.imageView(@IdRes idRes: Int): ImageView {
    return itemView.findViewById(idRes)
}

fun RecyclerView.ViewHolder.checkBox(@IdRes idRes: Int): CheckBox {
    return itemView.findViewById(idRes)
}

fun RecyclerView.ViewHolder.radio(@IdRes idRes: Int): RadioButton {
    return itemView.findViewById(idRes)
}

fun TabLayout.initDotView(itemCount: Int) {
    for(i in 1..itemCount)
        addTab(newTab())
}

fun TabLayout.setUpWithSlideView(sliderView: SliderView, viewChangedListener: SliderView.ViewChangedListener? = null) {
    if(sliderView.childCount == 0)
        return
    for(i in 1..sliderView.childCount)
        addTab(newTab())
    getTabAt(0)?.select()
    sliderView.viewChangeListener = object : SliderView.ViewChangedListener {
        override fun onViewChangedListener(v: View?, index: Int) {
            getTabAt(index)?.select()
            viewChangedListener?.onViewChangedListener(v, index)
        }

    }
}

fun TextView.drawUi(title: String, @ColorRes textColor: Int, @DrawableRes drawableRes: Int) {
    text = title
    drawUi(textColor, drawableRes)
}

fun TextView.drawUi(@StringRes title: Int, @ColorRes textColor: Int, @DrawableRes drawableRes: Int) {
    setText(title)
    drawUi(textColor, drawableRes)
}

fun TextView.drawUi(@ColorRes textColor: Int, @DrawableRes drawableRes: Int) {
    setTextColor(ContextCompat.getColor(context, textColor))
    setBackgroundResource(drawableRes)
}

fun TextView.color(@ColorRes colorRes: Int) {
    setTextColor(ContextCompat.getColor(context, colorRes))
}

fun View.setColor(@ColorRes colorRes: Int) {
    setBackgroundColor(ContextCompat.getColor(context, colorRes))
}

fun SliderView.config() {
    inAnimation = AnimationUtils.loadAnimation(context, R.anim.enter_from_right)
    outAnimation = AnimationUtils.loadAnimation(context, R.anim.exit_to_left)
}

fun <T : View> View.find(@IdRes resId: Int): Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(resId) }
}

fun <T : View> View.bind(@IdRes resId: Int): T {
    @Suppress("UNCHECKED_CAST")
    return findViewById(resId)
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}