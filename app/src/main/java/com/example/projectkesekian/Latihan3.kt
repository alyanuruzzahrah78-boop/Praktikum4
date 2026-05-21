package com.example.projectkesekian

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.content.Intent

class Latihan3 : AppCompatActivity() {

    private var username = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.hide()
        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
        setContentView(R.layout.activity_latihan3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        username = intent.getStringExtra("username") ?: ""

        val tvHeaderLatihan3 = findViewById<TextView>(R.id.tvHeaderLatihan3)
        val btnBerandaLatihan3 = findViewById<Button>(R.id.btnBerandaLatihan3)
        val btnTentangLatihan3 = findViewById<Button>(R.id.btnTentangLatihan3)

        tvHeaderLatihan3.text = "Selamat Datang $username"

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FragmentContainerLatihan3, BerandaFragment()).commit()
        }

        btnBerandaLatihan3.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FragmentContainerLatihan3, BerandaFragment()).commit()

        }

        btnTentangLatihan3.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.FragmentContainerLatihan3, TentangFragment()).commit()
        }
    }

    fun bukaLatihan4() {
        val intentLatihan3 = Intent(this, Latihan4::class.java)
        intentLatihan3.putExtra("username", username)
        startActivity(intentLatihan3)
    }
}