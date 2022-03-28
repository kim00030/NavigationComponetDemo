package com.dan.navigationcompoentdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_b.view.*

class FragmentB : Fragment() {


    private val args by navArgs<FragmentBArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_b, container, false)

        val firstName = args.currentUser.firstName
        val lastName = args.currentUser.lastName

        view.tv_text_view.text = "$firstName \n $lastName"
        return view
    }


}