package com.emedinaa.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.emedinaa.kotlinapp.adapter.TabsPagerAdapter
import com.emedinaa.kotlinapp.databinding.ActivityMainBinding

/**
 * @author Eduardo Medina
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupViewPager()
        setupTabs()
    }

    private fun setupViewPager(){
        binding.viewPager.adapter=
            TabsPagerAdapter(
                supportFragmentManager
            )
    }

    private fun setupTabs(){
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.tabLayout.setTabTextColors(
            ContextCompat.getColor(baseContext, R.color.gray),
            ContextCompat.getColor(baseContext, R.color.white))
        binding.tabLayout.setSelectedTabIndicatorColor(
            ContextCompat.getColor(baseContext, R.color.yellow))
    }
}