package com.example.aksharadeepa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LevelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        val subject = intent.getStringExtra("subject")

        val btnEasy = findViewById<Button>(R.id.btnEasy)
        val btnMedium = findViewById<Button>(R.id.btnMedium)
        val btnHard = findViewById<Button>(R.id.btnHard)

        btnEasy.setOnClickListener {

            val intent = Intent(this, QuizActivity::class.java)

            intent.putExtra("subject", subject)
            intent.putExtra("level", "Easy")

            startActivity(intent)
        }

        btnMedium.setOnClickListener {

            val intent = Intent(this, QuizActivity::class.java)

            intent.putExtra("subject", subject)
            intent.putExtra("level", "Medium")

            startActivity(intent)
        }

        btnHard.setOnClickListener {

            val intent = Intent(this, QuizActivity::class.java)

            intent.putExtra("subject", subject)
            intent.putExtra("level", "Hard")

            startActivity(intent)
        }
    }
}