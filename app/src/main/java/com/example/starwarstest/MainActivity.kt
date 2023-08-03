package com.example.starwarstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_search -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.searchFragment)
                    true
                }

                R.id.page_favorites -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.favoritesFragment)
                    true
                }

                else -> false
            }
        }
    }
}