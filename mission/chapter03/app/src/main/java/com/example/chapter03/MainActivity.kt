// MainActivity.kt
package com.example.chapter03

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chapter03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binder: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)
        // 미니 플레이어 클릭 시 SongActivity로 이동
        binder.btn.setOnClickListener {
            val intent = Intent(this, SongActivity::class.java)
            intent.putExtra("songTitle", "LILAC")
            intent.putExtra("artistName", "아이유")
            startActivity(intent)
        }
    }

    // SongActivity에서 돌아왔을 때 데이터를 받는 메소드
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SONG_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            val albumTitle = data?.getStringExtra("albumTitle")
            Toast.makeText(this, "앨범 제목: $albumTitle", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val SONG_ACTIVITY_REQUEST_CODE = 1
    }
}
