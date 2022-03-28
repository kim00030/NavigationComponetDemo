package com.dan.navigationcompoentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dan.navigationcompoentdemo.databinding.ActivityMainForViewPagerBinding

class MainActivityForViewPager : AppCompatActivity() {

    private lateinit var binding: ActivityMainForViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainForViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


    }
}