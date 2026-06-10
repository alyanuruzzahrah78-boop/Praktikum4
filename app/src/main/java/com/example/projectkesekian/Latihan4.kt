package com.example.projectkesekian

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Latihan4 : AppCompatActivity() {
    private lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan4)

        val mainView = findViewById<View>(R.id.main)
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        username = intent.getStringExtra("username") ?: ""

        if (savedInstanceState == null) {
            tampilkanFragment(HomeFragment())
        }

        // BARIS INI WAJIB ADA (Inisialisasi variabel)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.menu_home -> {
                    tampilkanFragment(HomeFragment())
                    true
                }
                R.id.menu_profile -> {
                    tampilkanFragment(ProfileFragment.newInstance(username))
                    true
                }
                R.id.menu_logout -> {
                    tampilkanDialogLogout()
                    true
                }
                else -> false
            }
        }
    }

    private fun tampilkanFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerLatihan4, fragment)
            .setReorderingAllowed(true)
            .commit()
    }

    private fun tampilkanDialogLogout() {
        AlertDialog.Builder(this)
            .setTitle("Logout")
            .setMessage("Apakah Anda yakin ingin logout?")
            .setPositiveButton("Ya") { _, _ -> finish() }
            .setNegativeButton("Tidak", null)
            .show()
    }
}