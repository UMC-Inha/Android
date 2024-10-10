package com.example.chapter01.shared

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.chapter01.R
import com.example.chapter01.databinding.ItemMoodBinding

//    1. Application 환경에 대한 정보 제공
//  Context는 애플리케이션 환경에 대한 정보를 제공합니다. 이를 통해 애플리케이션의 리소스, 데이터베이스, 파일 시스템 접근 등과 같은 기능에 접근할 수 있습니다.
//
//2. UI 요소에 대한 참조 제공
//  Context는 UI 구성 요소와 상호작용할 때 필요합니다. 예를 들어, TextView와 같은 뷰를 생성하고 스타일을 적용하는 데 사용됩니다.
//
//3. 리소스 접근
//  Context를 사용하여 애플리케이션의 리소스에 접근할 수 있습니다. 예를 들어, 문자열, 이미지, 레이아웃 파일 등을 가져오는 데 사용됩니다.

// 컨텐스트는 레이아웃이나 정보등을 담고 있는 것
class EmotionView constructor(
    context:Context,
    text:String="기본 텍스트",
    svgPath:Int
): ConstraintLayout(context){
    private var emotionText: String = text
    private var emotionSvgPath: Int = svgPath
    private val binding: ItemMoodBinding
    init {
//        xml 레이아웃을 뷰 객체로 변환
        binding = ItemMoodBinding.inflate(LayoutInflater.from(context), this, true)
        initView()
    }
    private fun initView(){
        binding.moodText.text=emotionText
        binding.moodIcon.setImageResource(emotionSvgPath)

    }
}