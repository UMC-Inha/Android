package com.umc.lifecycle

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.umc.lifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var memoText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextBtn.setOnClickListener {
            val intent = Intent(this, CheckActivity::class.java)
            intent.putExtra("memo", binding.mainEt.text.toString())
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        memoText?.let {
            binding.mainEt.setText(it)
        }
    }

    override fun onPause() {
        super.onPause()
        memoText = binding.mainEt.text.toString()
    }

    override fun onRestart() {
        super.onRestart()
        AlertDialog.Builder(this)
            .setTitle("다시 작성하시겠습니까?")
            .setMessage("이전 메모가 삭제됩니다.")
            .setPositiveButton("예") { _, _ ->
                memoText = null
                binding.mainEt.text.clear()
            }
            .setNegativeButton("아니오", null)
            .show()
    }
}