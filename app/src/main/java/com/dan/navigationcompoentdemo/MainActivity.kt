package com.dan.navigationcompoentdemo

import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dan.navigationcompoentdemo.databinding.ActivityMainBinding

/**
 * This is for using Navigation component.
 * It uses 1 Activity with multiple fragments
 * It consists of 3 key parts
 * -Navigation graph: a new xml resource type that defines all possible paths a user can take through
 * an app, It shows visually all the destination that can be reached from a given destination
 *
 * -NavHost: An empty container that displays destinations from your navigation graph.
 * The navigation component contains a default NavHost implementation, NavHostFragment, that
 * displays fragment destination
 *
 * -NavController: An object that manages app navigation within a NavHost. The NavController orchestrates
 * in the NavHost as users through your app
 *
 * Stevdza-San
 * https://www.youtube.com/watch?v=DI0NIk-7cz8&list=PLSrm9z4zp4mHilvsfUM3jeCYFV3fTAS3J
 *
 * dependencies: https://developer.android.com/guide/navigation/navigation-getting-started
 *
 * Leture Note: See@NavigationComponent.doc in /documents/Android lectures/NavigationComponent.doc
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //For NavigationDrawer
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var listener: NavController.OnDestinationChangedListener

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //R.id.fragment is for FragmentContainerView in the this activity xml
        //Navigation.findNavController(this, viewId)
        navController = findNavController(R.id.fragment)
        drawerLayout = binding.drawerLayout
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        binding.navigationView.setupWithNavController(navController)

        setupActionBarWithNavController(navController, appBarConfiguration)

        listener =
            NavController.OnDestinationChangedListener { controller, destination, arguments ->
                if (destination.id == R.id.firstFragment) {
                    supportActionBar?.setBackgroundDrawable(
                        ColorDrawable(getColor(com.google.android.material.R.color.design_default_color_primary))
                    )
                } else if (destination.id == R.id.secondFragment) {
                    supportActionBar?.setBackgroundDrawable(
                        ColorDrawable(getColor(com.google.android.material.R.color.design_default_color_secondary))
                    )
                }
            }
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        super.onPause()
        navController.removeOnDestinationChangedListener(listener)
    }

    override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(R.id.fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}