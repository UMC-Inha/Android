package com.umc.timer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.umc.timer.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var timerJob: Job? = null
    private var time = 0L
    private var isPaused = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.timerStartBtn.setOnClickListener {
            isPaused = !isPaused
            if(!isPaused) startTimer()
            else pauseTimer()
        }
        binding.timerClearBtn.setOnClickListener {clearTimer()}

    }

    private fun startTimer() {
        if(timerJob == null || !isPaused) {
            binding.timerStartBtn.text = "pause"
            timerJob = CoroutineScope(Dispatchers.Main).launch {
                while(isActive) {
                    time += 10
                    binding.timerTimeTv.text = formatTime(time)
                    delay(10L)
                }
            }
        }
    }

    private fun pauseTimer() {
        timerJob?.cancel()
        binding.timerStartBtn.text = "start"
    }

    private fun clearTimer() {
        time = 0L
        binding.timerTimeTv.text = formatTime(time)
        if(isPaused) pauseTimer()
    }

    private fun formatTime(time: Long): String {
        val minutes = time / 1000 / 60
        val seconds = (time / 1000) % 60
        val millis = (time % 1000) / 10
        return String.format( Locale.getDefault(), "%02d:%02d.%02d", minutes, seconds, millis)
    }
}