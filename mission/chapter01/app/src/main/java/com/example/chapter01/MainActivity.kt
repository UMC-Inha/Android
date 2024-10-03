package com.example.chapter01

import android.content.Intent
import com.example.chapter01.R
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chapter01.shared.EmotionView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        initEmotionView()
    }
    private fun initEmotionView(){
        val emotionSrc=R.drawable.emotion1
        val EmotionViewList:LinearLayout=findViewById(R.id.linear_emotion)
        val emotion_text= listOf("더없이 행복한 하루였어요","들뜨고 흥분되요","평범한 하루였어요","생각이 많아지고 불안해요","부글부글 화가 나요")
        val emotion_src= listOf(emotionSrc,emotionSrc,emotionSrc,emotionSrc,emotionSrc)
        for (index in 0 until emotion_text.size) {
            val emotionView=EmotionView(this,emotion_text[index],emotion_src[index])
            val intent = Intent(this, ExceptActivity::class.java)
            emotionView.setOnClickListener{
                intent.putExtra("text",emotion_text[index])
                intent.putExtra("imgSrc",emotion_src[index])
                startActivity(intent)
            }
            EmotionViewList.addView(emotionView)
        }
    }
}

// 애뮬 -> 젤 작은것 기준으로 할것
//일단 다 넣어 보고 string 넣어오기