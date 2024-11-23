package com.cms.login_practice

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cms.login_practice.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textview.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
            finish()
        }

        binding.button.setOnClickListener { login() }
    }

    private fun login() {
        if(binding.et1.text.toString().isEmpty()) {
            binding.et1.error = "Please enter email"
            return
        }
        if(binding.et3.text.toString().isEmpty()) {
            binding.et3.error = "Please enter password"
            return
        }
        val email = binding.et1.text.toString()
        val password = binding.et3.text.toString()

        val authService = AuthService()
        authService.setLoginView(this)

        authService.login(User(email, password, ""))

    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun saveJwt(jwt: String) {
        val spf = getSharedPreferences("auth", MODE_PRIVATE)
        val editor = spf.edit()
        editor.putString("jwt", jwt)
        editor.apply()
    }

    override fun onLoginSuccess(code: Int, result: Result) {
        when(code){
            1000 -> {
                saveJwt(result.jwt)
                Toast.makeText(this, result.username +"님 안녕하세요!", Toast.LENGTH_SHORT).show()
                startMainActivity()
            }
        }
    }

    override fun onLoginFailure() {
        TODO("Not yet implemented")
    }
}