package com.example.lab_week_02_c

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SingleTopActivity : AppCompatActivity() {

    private val instanceId get() = System.identityHashCode(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_single_top)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d("LaunchModeDemo", "SingleTopActivity onCreate instance=$instanceId taskId=$taskId")
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d("LaunchModeDemo", "SingleTopActivity onNewIntent instance=$instanceId taskId=$taskId")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LaunchModeDemo", "SingleTopActivity onDestroy instance=$instanceId")
    }
}
