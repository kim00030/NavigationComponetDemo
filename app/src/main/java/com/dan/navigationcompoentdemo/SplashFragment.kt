package com.dan.navigationcompoentdemo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //3 secs later navigate to launch ViewPager
        lifecycleScope.launch {
            delay(3000)

            //If Boarding is finished, navigate to HomeFrament
            if (onBoardingFinished()) {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment2)
            } else {
                //Navigate to ViewPager
                findNavController().navigate(R.id.navigateToViewPager)
            }
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun onBoardingFinished(): Boolean {

        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }
}