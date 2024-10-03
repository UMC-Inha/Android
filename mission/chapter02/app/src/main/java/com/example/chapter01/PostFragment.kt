package com.example.chapter01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chapter01.databinding.FragmentEmotionBinding
import com.example.chapter01.databinding.FragmentPostBinding


class PostFragment: Fragment() {
    private lateinit var binding: FragmentPostBinding
    override fun onCreateView(
        inflater: LayoutInflater, // LayoutInflater 매개변수로 받아옴
        container: ViewGroup?, // container 매개변수 추가
        savedInstanceState: Bundle? // savedInstanceState 매개변수 추가
    ): View? {
        binding = FragmentPostBinding.inflate(inflater, container, false) // inflater 사용
        return binding.root
    }
}