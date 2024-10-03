package com.example.chapter01
import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.chapter01.databinding.FragmentEmotionBinding
import com.example.chapter01.shared.EmotionView
import android.os.Bundle // Bundle 가져오기
import android.view.ViewGroup // ViewGroup 가져오기
import android.view.LayoutInflater
import androidx.fragment.app.Fragment

class EmotionFragment: Fragment()  {
    private lateinit var binding: FragmentEmotionBinding
    override fun onCreateView(
        inflater: LayoutInflater, // LayoutInflater 매개변수로 받아옴
        container: ViewGroup?, // container 매개변수 추가
        savedInstanceState: Bundle? // savedInstanceState 매개변수 추가
    ): View? {
        binding = FragmentEmotionBinding.inflate(inflater, container, false) // inflater 사용
        initEmotionView()
        return binding.root
    }
    private fun initEmotionView(){
        val emotionSrc=R.drawable.emotion1
        val EmotionViewList =binding.linearEmotion
        val emotion_text= listOf("더없이 행복한 하루였어요","들뜨고 흥분되요","평범한 하루였어요","생각이 많아지고 불안해요","부글부글 화가 나요")
        val emotion_src= listOf(emotionSrc,emotionSrc,emotionSrc,emotionSrc,emotionSrc)
        for (index in 0 until emotion_text.size) {
            val emotionView= EmotionView(requireContext(),emotion_text[index],emotion_src[index])
            val intent = Intent(requireContext(), ExceptActivity::class.java)
            val bundle=Bundle()
            emotionView.setOnClickListener{
                bundle.putString("text",emotion_text[index])
                bundle.putInt("imgSrc",emotion_src[index])
                intent.putExtras(bundle)
                startActivity(intent)
            }
            EmotionViewList.addView(emotionView)
        }
    }
}

