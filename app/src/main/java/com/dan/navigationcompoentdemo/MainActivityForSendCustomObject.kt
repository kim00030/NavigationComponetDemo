package com.dan.navigationcompoentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dan.navigationcompoentdemo.databinding.ActivityMainForSendCustomObjectBinding

class MainActivityForSendCustomObject : AppCompatActivity() {

    private lateinit var binding: ActivityMainForSendCustomObjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainForSendCustomObjectBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}