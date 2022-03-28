package com.dan.navigationcompoentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dan.navigationcompoentdemo.databinding.ActivityMainForBottomNavigationViewBinding

/**
 * This uses 3 Fragments (FirstFragment1, SecondFragment1, ThirdFragment1)
 * Navi Graph: my_nav_bottom_navigation.xml
 */
class MainActivityForBottomNavigationView : AppCompatActivity() {

    private lateinit var binding: ActivityMainForBottomNavigationViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainForBottomNavigationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {

        val bottomNavigationView = binding.bottomNavigationView
        //For bar
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.firstFragment1, R.id.secondFragment1, R.id.thirdFragment1
        ))
        val navController = findNavController(R.id.fragmentContainerView)
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)

    }
}