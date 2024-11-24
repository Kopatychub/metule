package com.example.matuleme.authFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.matuleme.R

class Register : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.auth_register, container, false)

        val linkToSign = view.findViewById<TextView>(R.id.link_to_sign)
        val backButton = view.findViewById<ImageButton>(R.id.r_backButton)

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        linkToSign.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }

}