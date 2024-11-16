package com.example.matuleme

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.matuleme.fragments.OnboardingFragment1
import com.example.matuleme.fragments.OnboardingFragment2
import com.example.matuleme.fragments.OnboardingFragment3

class OnboardigAdapter(onboarding: Onboarding): FragmentStateAdapter(onboarding) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardingFragment1()
            1 -> OnboardingFragment2()
            2 -> OnboardingFragment3()
            else -> OnboardingFragment1()
        }
    }
}