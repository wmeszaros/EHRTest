package com.example.ehrtest

import android.app.Application
import com.example.ehrtest.utils.Prefs

class App : Application() {
    companion object {
        var prefs: Prefs? = null
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }
}