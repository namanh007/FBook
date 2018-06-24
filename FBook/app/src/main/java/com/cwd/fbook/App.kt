package com.cwd.fbook

import android.app.Application

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class App : Application() {

    companion object {
        @Volatile
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }

}