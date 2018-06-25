package com.cwd.fbook.view

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.TextView
import com.cwd.fbook.R
import android.graphics.Shader.TileMode
import android.graphics.LinearGradient
import android.graphics.Shader



/**
 *  @Project: FBook
 *  @CreatedBy: Huy AGS 2018-06-25
 *  @Description: ...
 *  All Right Reserved.
 */
class CustomTextView : TextView {

    constructor(context: Context) : super(context) {
        initView(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    private fun initView(context: Context, attrs: AttributeSet?) {
        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomTextView, 0, 0)
        try {
            val colorStart = a.getInt(R.styleable.CustomTextView_gradientColorStart,
                    ContextCompat.getColor(context, android.R.color.white))
            val colorEnd = a.getInt(R.styleable.CustomTextView_gradientColorEnd,
                    ContextCompat.getColor(context, android.R.color.white))
            paint.shader  = LinearGradient(0f, 0f, width.toFloat(), 0f,
                    intArrayOf(colorStart, colorEnd),
                    floatArrayOf(0f, 1f), TileMode.CLAMP)

        } finally {
            a.recycle()
        }
    }
}

