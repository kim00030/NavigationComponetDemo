package com.dan.navigationcompoentdemo.onboarding.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.dan.navigationcompoentdemo.R
import kotlinx.android.synthetic.main.fragment_first_screen.view.*

class FirstScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first_screen, container, false)

        //get ViewPager
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpager)
        //view.next is "Next" TextView in FirstScreen
        view.next.setOnClickListener {
            //This leads to move to SecondScreen
            //Why 1?  index starts from 0
            viewPager?.currentItem = 1
        }

        return view
    }

}