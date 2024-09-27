package com.example.chapter01

import com.example.chapter01.R
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
    }
    private fun initEmotionView(){
        val emotionSrc=R.drawable.emotion1
        val emotion_text= listOf("더없이 행복한 하루였어요","들뜨고 흥분되요","평범한 하루였어요","생각이 많아지고 불안해요","부글부글 화가 나요")
        val emotion_src= listOf(emotionSrc,emotionSrc,emotionSrc,emotionSrc,emotionSrc)
    }
}

// 애뮬 -> 젤 작은것 기준으로 할것
//일단 다 넣어 보고 string 넣어오기