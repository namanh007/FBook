package com.cwd.fbook.util

import android.support.annotation.AnimRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.cwd.fbook.R

/**
 **************************************************************************************************
 * 
 *  @Project: FBook
 *  @CreatedBy: Huy AgilSun Quoc Vu 2018-06-14
 *  @LastEditor: Huy AgilSun Quoc Vu 2018-06-14
 *  @Description: ...
 *
 *                                      All Right Reserved.
 *
 **************************************************************************************************
 */
internal fun FragmentManager.remove(tag: String,
                                    @AnimRes slideIn: Int = R.anim.anim_righ_enter,
                                    @AnimRes slideOut: Int = R.anim.anim_left_exit) {

    this.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .remove(this.findFragmentByTag(tag))
            .commitNow()
}

internal fun FragmentManager.add(containerRes: Int,
                                 fragment: Fragment,
                                 tag: String,
                                 @AnimRes slideIn: Int = R.anim.anim_righ_enter,
                                 @AnimRes slideOut: Int = R.anim.anim_left_exit) {

    this.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .add(containerRes, fragment, tag)
            .commit()
}

internal fun FragmentManager.transaction(func: FragmentTransaction.() -> Unit) {

    val fragmentTransaction = beginTransaction()
    fragmentTransaction.setCustomAnimations(
            R.anim.anim_righ_enter,
            R.anim.anim_left_exit,
            R.anim.anim_left_enter,
            R.anim.anim_right_exit
    )
    fragmentTransaction.func()
    fragmentTransaction.commit()

}