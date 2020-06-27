package com.example.ehrtest.model

import android.util.Log

//Singleton User
object User {
    var userID: Int? = null
    var userName: String? = null
    var accessToken: String? = null
        set(value: String?) {
            Log.d("notify", "access token changed")
            field = value
        }
    var loggedIn: Boolean = false

    fun logout() {
        userID = null
        userName = null
        accessToken = null
    }
}