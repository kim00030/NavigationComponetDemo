package com.dan.navigationcompoentdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment : Fragment() {

    val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val myNumberPassedFromFirstFragment = args.number
        view.textView2.text = myNumberPassedFromFirstFragment.toString()
        view.textView2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.navigateToFirstFragment)
        }
        return view
    }

}