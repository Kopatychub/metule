package com.example.matuleme.authFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.matuleme.R
import com.example.matuleme.extensions.replaceFragment

class SignIn : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.auth_signin, container, false)

        val linkToReg = view.findViewById<TextView>(R.id.link_to_reg)

        linkToReg.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.main, Register())
        }

        return view
    }
}