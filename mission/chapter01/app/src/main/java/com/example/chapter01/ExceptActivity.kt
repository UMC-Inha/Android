package com.example.chapter01

import android.os.Bundle
import android.text.Html.ImageGetter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExceptActivity : AppCompatActivity() {
    private lateinit var text: String
    private lateinit var exceptText:TextView
    private lateinit var exceptImgae:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.except)
        setText(intent.getStringExtra("text") ?: "")
        setImage(intent.getIntExtra("imgSrc",0))
        initBackEvent()
    }
    private fun setText (text:String){
        exceptText=findViewById(R.id.except_text)
        exceptText.text=text;
    }
    private fun setImage(resourceId: Int) {
        exceptImgae=findViewById(R.id.except_img)
        exceptImgae.setImageResource(resourceId)
    }
    private fun initBackEvent(){
        var backBtn =findViewById<Button>( R.id.back_btn)
        backBtn.setOnClickListener{
            finish()
        }

    }
}