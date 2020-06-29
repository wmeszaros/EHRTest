package com.example.ehrtest.api

import com.example.ehrtest.data.AuthPostBody
import com.example.ehrtest.data.AuthResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthService {

    @Headers(
        "Content-Type: application/json; charset=utf-8",
        "x-ex-ehrdata-processid: 1",
        "x-ex-ehrdata-machinename: 5")
    @POST("register")
    fun getAuth(@Body body: AuthPostBody) : Call<AuthResult>
}