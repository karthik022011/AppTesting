package com.kartheek.apptesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kartheek.apptesting.databinding.ActivityMainBinding
import com.kartheek.apptesting.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}