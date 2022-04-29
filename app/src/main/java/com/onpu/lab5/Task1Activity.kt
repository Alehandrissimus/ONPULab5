package com.onpu.lab5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onpu.lab5.databinding.ActivityT1Binding

class Task1Activity: AppCompatActivity() {

    lateinit var binding: ActivityT1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
    }

    private fun setupBinding() {
        supportActionBar?.hide()

        binding = ActivityT1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}