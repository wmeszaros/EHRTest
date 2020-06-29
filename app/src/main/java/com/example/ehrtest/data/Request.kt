package com.example.ehrtest.data

import android.util.Log
import com.google.gson.Gson
import java.net.URL


class Request() {

    companion object { //1
        private val URL = "https://api.github.com/search/repositories"
        private val SEARCH = "q=language:kotlin&sort=stars&order=desc"
        private val COMPLETE_URL = "$URL?$SEARCH"
    }

    fun run(): RepoResult { //2
        val repoListJsonStr = URL(COMPLETE_URL).readText() //3
        return Gson().fromJson(repoListJsonStr, RepoResult::class.java) //4
    }
}

class AuthRequest {
    val url = "https://exscribemobile.com/ipad/register"

    fun run() {
        val returnString = URL(url).readText()
        Log.d("return", returnString)
    }
}