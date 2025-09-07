package com.example.lab_week_02_c

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "LaunchModeDemo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnStandard = findViewById<Button>(R.id.button_standard)
        val btnSingleTop = findViewById<Button>(R.id.button_single_top)

        btnStandard.setOnClickListener {
            Log.d(TAG, "MainActivity -> launching StandardActivity")
            startActivity(Intent(this, StandardActivity::class.java))
        }

        btnSingleTop.setOnClickListener {
            Log.d(TAG, "MainActivity -> launching SingleTopActivity")
            startActivity(Intent(this, SingleTopActivity::class.java))
        }
    }
}
