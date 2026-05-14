package com.example.aksharadeepa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val txtResult = findViewById<TextView>(R.id.txtResult)
        val btnHome = findViewById<Button>(R.id.btnHome)

        val score = intent.getIntExtra("score", 0)

        txtResult.text = "🏆 Your Score: $score / 5"

        btnHome.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}