package com.example.matuleme

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.matuleme.authFragments.Register
import com.example.matuleme.authFragments.SignIn
import com.example.matuleme.extensions.replaceFragment

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        if (savedInstanceState == null) {
            supportFragmentManager.replaceFragment(R.id.main, SignIn(), false)
        }

    }
}