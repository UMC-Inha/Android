package com.cms.login_practice

import android.util.Log
import retrofit2.Call
import retrofit2.Response

class AuthService {
    private lateinit var signUpView: SignUpView
    private lateinit var loginView: LoginView

    fun setSignUpView(signUpView: SignUpView){
        this.signUpView = signUpView
    }

    fun setLoginView(loginView: LoginView){
        this.loginView = loginView
    }

    fun signUp(user: User) {
        val authService = getRetrofit().create(AuthRetrofitInterface::class.java)

        authService.signUp(user).enqueue(object: retrofit2.Callback<AuthResponse>{
            override fun onResponse(p0: Call<AuthResponse>, p1: Response<AuthResponse>) {
                Log.d("SIGNUP/SUCCESS", p1.toString())
                val res: AuthResponse = p1.body()!!
                when(res.code) {
                    1000 -> signUpView.onSignUpSuccess()
                    else -> signUpView.onSignUpFailure()
                }
            }

            override fun onFailure(p0: Call<AuthResponse>, p1: Throwable) {
                Log.d("SIGNUP/FAILURE", p1.message.toString())
            }
        })
        Log.d("SIGNUP", "HELLO")
    }

    fun login(user: User) {
        val authService = getRetrofit().create(AuthRetrofitInterface::class.java)

        authService.login(user).enqueue(object: retrofit2.Callback<AuthResponse>{
            override fun onResponse(p0: Call<AuthResponse>, p1: Response<AuthResponse>) {
                Log.d("LOGIN/SUCCESS", p1.toString())
                val res: AuthResponse = p1.body()!!
                when(val code = res.code) {
                    1000 -> loginView.onLoginSuccess(code, res.result!!)
                    else -> loginView.onLoginFailure()
                }
            }

            override fun onFailure(p0: Call<AuthResponse>, p1: Throwable) {
                Log.d("LOGIN/FAILURE", p1.message.toString())
            }
        })
        Log.d("LOGIN", "HELLO")
    }
}