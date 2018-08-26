package com.cwd.fbook

import android.app.Application
import com.cwd.fbook.data.define.User

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class App : Application() {

    private var trimLevel: Int = 0
    private var user: User? = null

    companion object {
        @Volatile
        lateinit var instance: App

        fun setCurrentUser(user: User?) {
            instance.user = user
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(trimLevel)
        trimLevel++
    }

}