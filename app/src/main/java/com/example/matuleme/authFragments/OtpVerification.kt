package com.example.matuleme.authFragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.matuleme.R

class OtpVerification : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.auth_verification, container, false)

        val otpContainer = view.findViewById<LinearLayout>(R.id.otp_container)

        otpContainer.getChildAt(0).requestFocus()

        for (i in 0 until otpContainer.childCount) {
            setOtpAutoFocus(
                otpContainer.getChildAt(i) as EditText,
                if (i-1 >= 0) otpContainer.getChildAt(i-1) as EditText else null,
                if (i+1 != otpContainer.childCount) otpContainer.getChildAt(i+1) as EditText else null
            )
        }

        return view
    }

    private fun setOtpAutoFocus(current: EditText, prev: EditText?, next: EditText?) {
        current.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL) {
                if (current.text.isEmpty() && prev != null) {
                    prev.requestFocus()
                    prev.setText("")
                    true
                } else {
                    false
                }
            } else {
                false
            }
        }

        current.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    next?.requestFocus()
                }
                if (next?.length() == 1) {
                    next.selectAll()
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })
    }
}