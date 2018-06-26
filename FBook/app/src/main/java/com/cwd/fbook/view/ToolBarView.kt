package com.cwd.fbook.view

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.cwd.fbook.R
import kotlinx.android.synthetic.main.view_appbar.view.*

/**
 * Created by tykud on 26/06/2018.
 */
class ToolBarView : LinearLayout {
    constructor(context: Context) : super(context) {
        initView(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    private fun initView(context: Context, attrs: AttributeSet?) {

        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.AppBarView, 0, 0)

        try {
            LayoutInflater.from(context).inflate(R.layout.view_appbar, this)
            val title = a.getString(R.styleable.AppBarView_appbarTitle)
            val leftIcon = a.getResourceId(R.styleable.AppBarView_appbarLeftIcon, -1)
            val rightIcon = a.getResourceId(R.styleable.AppBarView_appbarRightIcon, -1)
            appbar_textView_title.text = title
            appbar_view_leftIcon.setOnClickListener {
                (context as? Activity)?.onBackPressed()
            }
            if (leftIcon != -1)
                appbar_view_leftIcon.setImageResource(leftIcon)
            if (rightIcon != -1)
                appbar_view_rightIcon.setImageResource(rightIcon)

        } finally {
            a.recycle()
        }

    }

    var title: String
        get() = appbar_textView_title.text.toString()
        set(value) {
            appbar_textView_title.text = value
        }

    var leftIconClickListener: View.OnClickListener?
        get() = leftIconClickListener
        set(value) {
            leftIconClickListener = value
            appbar_view_leftIcon.setOnClickListener(leftIconClickListener)
        }

    var rightIconClickListener: View.OnClickListener?
        get() = rightIconClickListener
        set(value) {
            rightIconClickListener = value
            appbar_view_rightIcon.setOnClickListener(rightIconClickListener)
        }
}