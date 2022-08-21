package com.example.basketballscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basketballscore.databinding.ActivityFinalResultBinding

class FinalResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityFinalResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityFinalResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}