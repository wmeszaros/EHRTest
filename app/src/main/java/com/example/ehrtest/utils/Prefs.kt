package com.example.ehrtest.utils

import android.content.Context
import android.content.SharedPreferences

class Prefs (context: Context) {
    val PREFS_FILENAME = "com.example.ehrtest.prefs"
    val USERNAME = "username"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0);

    var username: String?
        get() = prefs.getString(USERNAME, null)
        set(value) = prefs.edit().putString(USERNAME, value).apply()
}