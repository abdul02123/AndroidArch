package com.android.androidarchapp.base

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object{
        private lateinit var appContext: BaseApplication
        fun getInstance(): BaseApplication{
            return appContext
        }
    }
}