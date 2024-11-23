package com.example.matuleme

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2

class Onboarding : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var startButton: Button
    private lateinit var adapter: OnboardigAdapter
    private lateinit var indicatorLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewpager)
        startButton = findViewById(R.id.start_button)
        indicatorLayout = findViewById(R.id.indicatorLayout)

        adapter = OnboardigAdapter(this)

        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateButton(position)
                updateIndicator(position)
            }
        })

        updateButton(0)
        setIndicators(adapter.itemCount)

        startButton.setOnClickListener {
            if (viewPager.currentItem == adapter.itemCount - 1) {
                startMainActivity()
            } else {
                viewPager.currentItem += 1
            }
        }
    }

    private fun animateIndicator(indicator: View, targetWidth: Int) {
        val initialWidth = indicator.width

        val animator = ValueAnimator.ofInt(initialWidth, targetWidth).apply {
            addUpdateListener { animation ->
                indicator.layoutParams = indicator.layoutParams.apply {
                    width = animation.animatedValue as Int
                }
                indicator.requestLayout()
            }
        }

        animator.duration = 200
        animator.start()
    }

    private fun updateIndicator(position: Int) {
        for (i in 0 until indicatorLayout.childCount){
            val indicator = indicatorLayout.getChildAt(i) as View

            if (position == i) {
                indicator.setBackgroundResource(R.drawable.active_line_indicator)
                animateIndicator(indicator, 120)

            } else {
                indicator.setBackgroundResource(R.drawable.inactive_line_indicator)
                animateIndicator(indicator, 80)
            }
        }
    }

    private fun setIndicators(count: Int){
        for (i in 0 until count){
            val indicator = View(this).apply {
                layoutParams = LinearLayout.LayoutParams (
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(10,0, 10, 0)

                    height = 15
                    width = 80

                }
                background = ContextCompat.getDrawable(context, R.drawable.inactive_line_indicator)

            }
            indicatorLayout.addView(indicator)
        }
        updateIndicator(0)
    }

    private fun updateButton(position: Int) {
        when (position) {
            adapter.itemCount - 3 -> {
                startButton.text = "Начать"
            }
            else -> {
                startButton.text = "Далее"
            }
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this@Onboarding, AuthActivity::class.java)
        startActivity(intent)
    }
}