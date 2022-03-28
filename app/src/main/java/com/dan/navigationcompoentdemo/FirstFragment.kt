package com.dan.navigationcompoentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        view.textView1.setOnClickListener {
            //passing 22 in secondFragment
            //FirstFragmentDirections is generated and it's referred to FirstFragment in my_nav.xml
            //if you don't pass 22. it will pass default value I set argument
            val action = FirstFragmentDirections.navigateToSecondFragment(22)
            //Looks like Navigation is singleton
            Navigation.findNavController(view).navigate(action)
        }
        return view
    }
}