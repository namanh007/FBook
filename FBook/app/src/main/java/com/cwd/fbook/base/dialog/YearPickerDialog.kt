package com.cwd.fbook.base.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.NumberPicker
import com.cwd.fbook.R
import java.util.*


/**
 * Created by tykud on 25/06/2018.
 */
class YearPickerDialog : DialogFragment() {
    private val MIN_VALUE = Calendar.getInstance().get(Calendar.YEAR) - 65
    private val MAX_VALUE = Calendar.getInstance().get(Calendar.YEAR)

    private var minValue: Int? = null
    private var maxValue: Int? = null

    fun setValueLimit(minValue: Int, maxValue: Int){
        this.minValue = minValue
        this.maxValue = maxValue
    }

    private var onValueChangeListener: OnValueChangeListener? = null

    fun setOnValueChangeListener(onValueChangeListener: OnValueChangeListener) {
        this.onValueChangeListener = onValueChangeListener
    }



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val numberPicker = NumberPicker(activity)
            numberPicker.computeScroll()
        if(maxValue == null && minValue == null){
            //min value
            numberPicker.minValue = MIN_VALUE

            //max value
            numberPicker.maxValue = MAX_VALUE
        }else{
            //min value
            numberPicker.minValue = minValue!!

            //max value
            numberPicker.maxValue = maxValue!!
        }

        val ab = AlertDialog.Builder(activity, R.style.YearPickerDialog)

        ab.setPositiveButton(R.string.add, { dialogInterface, i ->
            onValueChangeListener?.onValueChangeListener(numberPicker.value)
            dialogInterface.dismiss()
        })

        ab.setView(numberPicker)

        return ab.create()
    }

    interface OnValueChangeListener {
        fun onValueChangeListener(value: Int)
    }
}