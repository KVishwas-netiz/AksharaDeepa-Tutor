package com.example.aksharadeepa

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProgressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        val progressText = findViewById<TextView>(R.id.progressText)
        val prefs = getSharedPreferences("progress", MODE_PRIVATE)

        val ch1 = prefs.getBoolean("ch1", false)
        val ch2 = prefs.getBoolean("ch2", false)
        val ch3 = prefs.getBoolean("ch3", false)

        var count = 0
        if (ch1) count++
        if (ch2) count++
        if (ch3) count++

        val percent = (count * 100) / 3

        progressText.text = "Progress: $percent%"
    }
}