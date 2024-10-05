package com.example.chapter01

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.chapter01.databinding.ActivityMainBinding
import com.example.chapter01.databinding.FragmentEmotionBinding
import com.example.chapter01.shared.EmotionView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var type = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = Bundle()
        binding = ActivityMainBinding.inflate(layoutInflater) // inflater 사용
        setContentView(binding.root) // 뷰 바인딩으로 설정
        initFragment(bundle)
        initNavuBarEvent()
    }

    fun initFragment(savedInstanceState:Bundle){
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, PostFragment()) // fragmentContainer는 Fragment가 들어갈 Container의 ID
            .commit()
    }
    fun initNavuBarEvent(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)as? NavHostFragment
//        프라그먼트가 삽입될 컨테이너
        val navController = navHostFragment?.navController
//        프라그먼트 간 이동제어 객체
        if (navController != null) {
            binding.bottomNavigation.setupWithNavController(navController)
        }
//        내비게이션 설정
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(PostFragment(),1,type)
                    startActivity(intent)
                    true
                }
                R.id.navigation_social -> {
                    replaceFragment(EmotionFragment(),2,type)
                    true
                }
                R.id.navigation_record -> {
                    replaceFragment(EmotionFragment(),3,type)
                    true
                }
                R.id.navigation_mypage -> {
                    replaceFragment(EmotionFragment(),4,type)
                    true
                }
                else -> false
            }
        }
//        내비게이션 방향 설정

        fun hideBottomNavigation(state: Boolean) {
            if (state) binding.bottomNavigation.visibility = View.GONE else binding.bottomNavigation.visibility = View.VISIBLE
        }
    }
    private fun replaceFragment(fragment: Fragment,fragmentType:Int,presentType:Int) {
        type=fragmentType
        var enterAnim:Int
        var exitAnim:Int
        if (fragmentType>presentType){
            enterAnim = R.anim.slide_in_right
            exitAnim = R.anim.slide_out_left

        }
        else if (fragmentType==presentType){
            return
        }
        else{
            enterAnim = R.anim.slide_in_left
            exitAnim = R.anim.slide_out_right
        }

        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                enterAnim ,exitAnim
            )
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}
