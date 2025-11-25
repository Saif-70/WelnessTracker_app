package com.example.wellnesstracker

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var screenDashboard: View
    private lateinit var screenActivity: View
    private lateinit var screenStats: View
    private lateinit var screenProfile: View
    private lateinit var screenMap: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find screens
        screenDashboard = findViewById(R.id.screenDashboard)
        screenActivity = findViewById(R.id.screenActivity)
        screenStats = findViewById(R.id.screenStats)
        screenProfile = findViewById(R.id.screenProfile)
        screenMap = findViewById(R.id.screenMap)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Default screen
        showScreen(Screen.DASHBOARD)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_dashboard -> showScreen(Screen.DASHBOARD)
                R.id.nav_activity -> showScreen(Screen.ACTIVITY)
                R.id.nav_stats -> showScreen(Screen.STATS)
                R.id.nav_profile -> showScreen(Screen.PROFILE)
                R.id.nav_map -> showScreen(Screen.MAP)
            }
            true
        }
    }

    private fun showScreen(screen: Screen) {
        screenDashboard.visibility = if (screen == Screen.DASHBOARD) View.VISIBLE else View.GONE
        screenActivity.visibility = if (screen == Screen.ACTIVITY) View.VISIBLE else View.GONE
        screenStats.visibility = if (screen == Screen.STATS) View.VISIBLE else View.GONE
        screenProfile.visibility = if (screen == Screen.PROFILE) View.VISIBLE else View.GONE
        screenMap.visibility = if (screen == Screen.MAP) View.VISIBLE else View.GONE
    }

    private enum class Screen {
        DASHBOARD, ACTIVITY, STATS, PROFILE, MAP
    }
}
