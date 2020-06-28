package com.example.ehrtest.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.ehrtest.R

class Prefs (context: Context) {

    //Login

    val CLIENT = R.string.CLIENT.toString()
    val SECRET = R.string.SECRET.toString()
    val USERNAME = R.string.USERNAME.toString()
    val PASSWORD = R.string.PASSWORD.toString()
    val prefs: SharedPreferences = context.getSharedPreferences(R.string.PREFS_FILENAME.toString(), 0);

    var client: String?
        get() = prefs.getString(CLIENT, null)
        set(value) = prefs.edit().putString(CLIENT, value).apply()

    var secret: String?
        get() = prefs.getString(SECRET, null)
        set(value) = prefs.edit().putString(SECRET, value).apply()

    var username: String?
        get() = prefs.getString(USERNAME, null)
        set(value) = prefs.edit().putString(USERNAME, value).apply()

    var password: String?
        get() = prefs.getString(PASSWORD, null)
        set(value) = prefs.edit().putString(PASSWORD, value).apply()
}