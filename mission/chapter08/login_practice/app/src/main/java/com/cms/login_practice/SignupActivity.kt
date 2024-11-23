package com.cms.login_practice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cms.login_practice.databinding.ActivitySignupBinding
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response

class SignupActivity : AppCompatActivity(), SignUpView{

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textview.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding.button.setOnClickListener { signUp() }

    }

    private fun getUser(): User {
        val email: String = binding.et1.text.toString()
        val name: String = binding.et2.text.toString()
        val password: String = binding.et3.text.toString()

        return User(email, name, password)
    }

    private fun signUp() {
        if(binding.et1.text.toString().isEmpty()) {
            binding.et1.error = "Please enter email"
            return
        }
        if(binding.et2.text.toString().isEmpty()) {
            binding.et2.error = "Please enter name"
            return
        }
        if(binding.et3.text.toString().isEmpty()) {
            binding.et3.error = "Please enter password"
            return
        }

        val authService = AuthService()
        authService.setSignUpView(this)

        authService.signUp(getUser())
    }

    override fun onSignUpSuccess() {
        Toast.makeText(this@SignupActivity, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
        finish()
    }

    override fun onSignUpFailure() {
        Toast.makeText(this@SignupActivity, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
    }
}