package com.example.chapter03
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chapter03.databinding.ActivityMainBinding
import com.example.chapter03.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    lateinit var binding: ActivitySongBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // MainActivity에서 전달된 노래 제목과 가수명 받기
        val songTitle = intent.getStringExtra("songTitle")
        val artistName = intent.getStringExtra("artistName")

        binding.songTitle.text = songTitle
        binding.artistName.text = artistName

        // SongActivity에서 앨범 제목을 반환하며 MainActivity로 돌아가기
        binding.backBtn.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("albumTitle", "Real IU")
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
