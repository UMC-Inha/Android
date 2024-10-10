package com.example.chapter01

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.chapter01.databinding.ActivityExceptBinding
import com.example.chapter01.databinding.ActivityMainBinding
import com.example.chapter01.databinding.ItemMoodBinding

class ExceptActivity : AppCompatActivity() {
    private lateinit var text: String
    private lateinit var exceptText:TextView
    private lateinit var exceptImgae:ImageView
    private lateinit var binding: ActivityExceptBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExceptBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setText(intent.getStringExtra("text") ?: "")
        setImage(intent.getIntExtra("imgSrc",0))
        initBackEvent()
    }
    private fun setText (text:String){
        binding.exceptText.text=text
    }
    private fun setImage(resourceId: Int) {
        binding.exceptImg.setImageResource(resourceId)
    }
    private fun initBackEvent(){
        var backBtn =findViewById<Button>( R.id.back_btn)
        backBtn.setOnClickListener{
            finish()
        }

    }
}