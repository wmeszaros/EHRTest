package com.example.ehrtest.data

data class AuthResult (
//    val error: String?,
    val ApiUrl: String?,
//    val clientIPA: String?,
    var AuthUrl: String?,
    var ClientId: String?,
    var DeviceName: String?,
    var ExternalAddress: String?,
    var InternalAddress: String?,
    var UserName: String?
//    var authRoot: String?,
//    var apiRoot: String?
)

class AuthPostBody(val ClientId: String,
                  val ClientSecret: String,
                  val UserName: String,
                  val DeviceName: String) {}