package com.cwd.fbook.util

import android.view.View
import android.view.animation.Animation
import android.view.animation.OvershootInterpolator
import android.view.animation.ScaleAnimation

/**
 *  @Project: FBook
 *  @CreatedBy: Huy AGS 2018-06-23
 *  @Description: ...
 *  All Right Reserved.
 */
fun View.animateBumped() {
    val scale: Animation = ScaleAnimation(0f, 1f, 0f, 1f,
            ScaleAnimation.RELATIVE_TO_SELF, .5f,
            ScaleAnimation.RELATIVE_TO_SELF, .5f)
    scale.duration = 300
    scale.interpolator = OvershootInterpolator()
    this.startAnimation(scale)
}

fun View.animateVanish() {
    val scale: Animation = ScaleAnimation(0f, 1f, 0f, 1f,
            ScaleAnimation.RELATIVE_TO_SELF, .0f,
            ScaleAnimation.RELATIVE_TO_SELF, .0f)
    scale.duration = 300
    scale.interpolator = OvershootInterpolator()
    this.startAnimation(scale)
}