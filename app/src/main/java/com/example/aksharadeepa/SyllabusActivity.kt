package com.example.aksharadeepa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SyllabusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syllabus)

        val btnMath = findViewById<Button>(R.id.btnMath)
        val btnScience = findViewById<Button>(R.id.btnScience)
        val btnEnglish = findViewById<Button>(R.id.btnEnglish)

        btnMath.setOnClickListener {
            openQuiz("Mathematics")
        }

        btnScience.setOnClickListener {
            openQuiz("Science")
        }

        btnEnglish.setOnClickListener {
            openQuiz("English")
        }
    }

    private fun openQuiz(subject: String) {

        val intent = Intent(this, QuizActivity::class.java)

        intent.putExtra("subject", subject)

        startActivity(intent)
    }
}