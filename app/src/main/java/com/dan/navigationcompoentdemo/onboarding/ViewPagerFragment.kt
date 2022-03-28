package com.dan.navigationcompoentdemo.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dan.navigationcompoentdemo.R
import com.dan.navigationcompoentdemo.onboarding.screens.FirstScreen
import com.dan.navigationcompoentdemo.onboarding.screens.SecondScreen
import com.dan.navigationcompoentdemo.onboarding.screens.ThirdScreen
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(), SecondScreen(), ThirdScreen()
        )

        val adapter =
            ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        //view.viewpager is referred to ViewPager in this layout(id:viewPager)
        view.viewpager.adapter = adapter
        return view
    }

}