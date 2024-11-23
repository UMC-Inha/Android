package com.cms.login_practice

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: Result?
)

data class Result(
    @SerializedName("userIdx") var userIdx: Int,
    @SerializedName("username") var username: String,
    @SerializedName("jwt") var jwt: String
)
