package com.example.aksharadeepa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    private var darkMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMath = findViewById<Button>(R.id.btnMath)
        val btnScience = findViewById<Button>(R.id.btnScience)
        val btnEnglish = findViewById<Button>(R.id.btnEnglish)

        btnMath.setOnClickListener {

            val intent = Intent(this, LevelActivity::class.java)
            intent.putExtra("subject", "Mathematics")
            startActivity(intent)
        }

        btnScience.setOnClickListener {

            val intent = Intent(this, LevelActivity::class.java)
            intent.putExtra("subject", "Science")
            startActivity(intent)
        }

        btnEnglish.setOnClickListener {

            val intent = Intent(this, LevelActivity::class.java)
            intent.putExtra("subject", "English")
            startActivity(intent)
        }

        }
        }

