package com.cms.login_practice

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthRetrofitInterface {
    @POST("/users")
    fun signUp(@Body user:User): Call<AuthResponse>

    @POST("/login")
    fun login(@Body user:User): Call<AuthResponse>
}