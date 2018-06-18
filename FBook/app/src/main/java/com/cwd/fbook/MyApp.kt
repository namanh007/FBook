package com.cwd.fbook

import android.app.Application

/**
 **************************************************************************************************
 * 
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-14
 *  @LastEditor: CWD Huy 2018-06-14
 *  @Description: ...
 *
 *                                      All Right Reserved.
 *
 **************************************************************************************************
 */
class MyApp : Application() {

    companion object {
        @Volatile
        lateinit var instance: MyApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }

}