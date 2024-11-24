package com.example.matuleme.authFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.matuleme.R
import com.example.matuleme.extensions.replaceFragment

class ForgotPassword : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.auth_password_fogot, container, false)

        val backButton = view.findViewById<ImageButton>(R.id.f_backButton)
        val confirm = view.findViewById<Button>(R.id.button_to_verification)

        confirm.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.main, OtpVerification())
        }

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }
}