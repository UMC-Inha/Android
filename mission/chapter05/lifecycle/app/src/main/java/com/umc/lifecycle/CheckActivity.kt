package com.umc.lifecycle

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.umc.lifecycle.databinding.ActivityCheckBinding

class CheckActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheckBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val memoText = intent.getStringExtra("memo")
        binding.checkMemoTv.text = memoText
    }
}