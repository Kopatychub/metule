package com.example.matuleme.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun FragmentManager.replaceFragment(
    containerId: Int,
    fragment: Fragment,
    addToBackStack: Boolean = true
) {
    val transaction = beginTransaction()
    transaction.replace(containerId, fragment)
    if (addToBackStack) {
        transaction.addToBackStack(null)
    }
    transaction.commit()
}