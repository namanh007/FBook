package com.cwd.fbook.view

import android.content.Context
import android.support.annotation.AttrRes
import android.support.annotation.NonNull
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ViewFlipper
import com.cwd.fbook.R


/**
 * *******************************************
 * * Created by Huy on 20/05/18.
 * * All rights reserved
 * *******************************************
 */
class SliderView : ViewFlipper {

    interface ViewChangedListener {
        fun onViewChangedListener(v: View?, index: Int)
    }

    private var whichChild = 0
    private lateinit var nextPerformAnimation: Animation
    private lateinit var nextExitAnimation: Animation
    private lateinit var backPerformAnimation: Animation
    private lateinit var backExitAnimation: Animation
    var viewChangeListener: ViewChangedListener? = null

    constructor(context: Context) : super(context) {
        initView(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    private fun initView(@NonNull context: Context, attrs: AttributeSet?) {
        nextPerformAnimation = AnimationUtils.loadAnimation(context, R.anim.enter_from_right)
        nextExitAnimation = AnimationUtils.loadAnimation(context, R.anim.exit_to_left)
        backPerformAnimation = AnimationUtils.loadAnimation(context, R.anim.enter_from_left)
        backExitAnimation = AnimationUtils.loadAnimation(context, R.anim.exit_to_right)
    }

    var next = true
    override fun showNext() {
        next = true
        displayedChild = whichChild + 1

    }

    override fun showPrevious() {
        next = false
        displayedChild = whichChild - 1
    }

    override fun setDisplayedChild(whichChild: Int) {
        this.whichChild = whichChild
        if(whichChild >= childCount) {
            this.whichChild = 0
        } else if(whichChild < 0) {
            this.whichChild = childCount - 1
        }

        val hasFocus = focusedChild != null
        if(next)
            next(whichChild)
        else
            previous(whichChild)
        if(hasFocus)
            requestFocus(View.FOCUS_FORWARD)

        viewChangeListener?.onViewChangedListener(this.currentView, this.whichChild)
    }

    private fun next(childIndex: Int) {
        val count = childCount
        for(i in 0 until count) {
            val child = getChildAt(i)
            if(i == childIndex) {
                child.startAnimation(nextPerformAnimation)
                child.visibility = View.VISIBLE
            } else {
                if(child.visibility == View.VISIBLE) {
                    child.startAnimation(nextExitAnimation)
                } else if(child.animation === nextPerformAnimation)
                    child.clearAnimation()
                child.visibility = View.GONE
            }
        }
    }

    private fun previous(childIndex: Int) {
        val count = childCount
        for(i in 0 until count) {
            val child = getChildAt(i)
            if(i == childIndex) {
                child.startAnimation(backPerformAnimation)
                child.visibility = View.VISIBLE
            } else {
                if(child.visibility == View.VISIBLE) {
                    child.startAnimation(backExitAnimation)
                } else if(child.animation === backPerformAnimation)
                    child.clearAnimation()
                child.visibility = View.GONE
            }
        }
    }

    override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
        super.addView(child, index, params)
        if(childCount == 1)
            child.visibility = View.VISIBLE
        else
            child.visibility = View.GONE
        if(index in 0..whichChild)
            displayedChild = whichChild + 1

    }

    override fun removeAllViews() {
        super.removeAllViews()
        whichChild = 0
    }

    override fun removeViewAt(index: Int) {
        super.removeViewAt(index)
        val childCount = childCount
        when {
            childCount == 0 -> whichChild = 0
            whichChild >= childCount -> displayedChild = childCount - 1
            whichChild == index -> displayedChild = whichChild
        }
    }

    override fun removeViews(start: Int, count: Int) {
        super.removeViews(start, count)
        if(childCount == 0)
            whichChild = 0
        else if(whichChild >= start && whichChild < start + count)
            displayedChild = whichChild
    }

    override fun getCurrentView(): View? {
        return getChildAt(whichChild)
    }
}