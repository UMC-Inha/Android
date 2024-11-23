package com.umc.recyclertest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.umc.recyclertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fruitList = listOf(
            Fruit(R.drawable.coupang, "사과", 3000),
            Fruit(R.drawable.coupang, "바나나", 1500),
            Fruit(R.drawable.coupang, "오렌지", 2000),
            Fruit(R.drawable.coupang, "딸기", 5000),
            Fruit(R.drawable.coupang, "수박", 10000),
            Fruit(R.drawable.coupang, "포도", 4000),
            Fruit(R.drawable.coupang, "파인애플", 7000),
            Fruit(R.drawable.coupang, "망고", 6000),
            Fruit(R.drawable.coupang, "블루베리", 8000),
            Fruit(R.drawable.coupang, "복숭아", 3500)
        )

        binding.mainRv.layoutManager = LinearLayoutManager(this)
        binding.mainRv.adapter = FruitAdapter(fruitList)


    }
}