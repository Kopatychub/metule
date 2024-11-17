package com.example.matuleme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class Onboarding : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var startButton: Button
    private lateinit var adapter: OnboardigAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewpager)
        startButton = findViewById(R.id.start_button)

        adapter = OnboardigAdapter(this)

        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateButton(position)
            }
        })

        updateButton(0)

        startButton.setOnClickListener {
            if (viewPager.currentItem == adapter.itemCount - 1) {
                startMainActivity()
            } else {
                viewPager.currentItem += 1
            }
        }
    }



    private fun updateButton(position: Int) {
        when (position) {
            adapter.itemCount - 3 -> {
                startButton.text = "Начать" // Изменение текста для последней страницы
            }

            else -> {
                startButton.text = "Далее" // Изменение текста для других страниц
            }
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this@Onboarding, MainActivity::class.java)
        startActivity(intent)
    }
}