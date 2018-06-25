package com.cwd.fbook.view

import android.content.Context
import android.support.v4.content.ContextCompat
import android.text.InputFilter
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import com.cwd.fbook.R
import com.cwd.fbook.util.animateBumped
import com.cwd.fbook.util.animateVanish
import kotlinx.android.synthetic.main.view_input.view.*

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class InputView : LinearLayout {

    constructor(context: Context) : super(context) {
        initView(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    private fun initView(context: Context, attrs: AttributeSet?) {

        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.InputView, 0, 0)

        try {

            val label = a.getString(R.styleable.InputView_inputLabel)
            val text = a.getString(R.styleable.InputView_android_text)
            val hint = a.getString(R.styleable.InputView_android_hint)
            val inputType = a.getInt(R.styleable.InputView_android_inputType, EditorInfo.TYPE_CLASS_TEXT)
            val maxLength = a.getInt(R.styleable.InputView_android_maxLength, 100)
            val maxLines = a.getInt(R.styleable.InputView_android_maxLines, 1)
            val labelColor = a.getInt(R.styleable.InputView_inputLabelColor, ContextCompat.getColor(context, R.color.colorPrimary))
            val textColor = a.getInt(R.styleable.InputView_android_textColor, ContextCompat.getColor(context, R.color.Grey))
            val editable = a.getBoolean(R.styleable.InputView_android_editable, true)

            LayoutInflater.from(context).inflate(R.layout.view_input, this)
            isClickable = true

            inputView_textView_label.text = label
            inputView_textView_label.setTextColor(labelColor)

            inputView_editText.setText(text)
            inputView_editText.hint = hint ?: null
            inputView_editText.setTextColor(textColor)
            inputView_editText.inputType = inputType
            val arr = arrayOfNulls<InputFilter>(1)
            arr[0] = InputFilter.LengthFilter(maxLength)
            inputView_editText.filters = arr
            inputView_editText.maxLines = maxLines
            if(!editable) inputView_editText.setOnKeyListener(null)

        } finally {
            a.recycle()
        }

    }

    var text: String?
        get() = inputView_editText.text.toString()
            set(value) {
            inputView_editText.setText(value)
        }

    var error: String?
        get() = inputView_textView_hint.text.toString()
        set(value) {
            inputView_textView_hint.text = value
            if(value.isNullOrEmpty())
                inputView_textView_hint.animateVanish()
            else
                inputView_textView_hint.animateBumped()
        }
}