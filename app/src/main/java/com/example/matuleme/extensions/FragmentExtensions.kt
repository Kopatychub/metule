package com.example.matuleme.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.matuleme.R

fun FragmentManager.replaceFragment(
    containerId: Int,
    fragment: Fragment,
    addToBackStack: Boolean = true
) {
    val transaction = beginTransaction()

    transaction.setCustomAnimations(
        R.anim.scale_fade_in,
        R.anim.scale_fade_out,
        R.anim.scale_fade_in,
        R.anim.scale_fade_out,
    )

    transaction.replace(containerId, fragment)

    if (addToBackStack) {
        transaction.addToBackStack(null)
    }

    transaction.commit()
}