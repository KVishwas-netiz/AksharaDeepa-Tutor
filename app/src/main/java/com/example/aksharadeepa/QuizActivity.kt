package com.example.aksharadeepa

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private lateinit var txtQuestion: TextView
    private lateinit var txtScore: TextView
    private lateinit var txtTimer: TextView

    private lateinit var option1: RadioButton
    private lateinit var option2: RadioButton
    private lateinit var option3: RadioButton
    private lateinit var option4: RadioButton

    private lateinit var radioGroup: RadioGroup
    private lateinit var btnNext: Button
    private lateinit var progressBar: ProgressBar

    private lateinit var questions: Array<String>
    private lateinit var answers: Array<String>

    private var currentQuestion = 0
    private var score = 0

    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        txtQuestion = findViewById(R.id.txtQuestion)
        txtScore = findViewById(R.id.txtScore)
        txtTimer = findViewById(R.id.txtTimer)

        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)

        radioGroup = findViewById(R.id.radioGroup)
        btnNext = findViewById(R.id.btnNext)
        progressBar = findViewById(R.id.progressBar)

        val subject = intent.getStringExtra("subject")
        val level = intent.getStringExtra("level")

        title = "$subject - $level"

        // =========================
        // MATHEMATICS
        // =========================

        if (subject == "Mathematics") {

            if (level == "Easy") {

                questions = arrayOf(
                    "2 + 2 = ?",
                    "5 + 3 = ?",
                    "10 - 5 = ?",
                    "3 × 2 = ?",
                    "8 ÷ 2 = ?"
                )

                answers = arrayOf(
                    "4",
                    "8",
                    "5",
                    "6",
                    "4"
                )

            } else if (level == "Medium") {

                questions = arrayOf(
                    "12 + 8 = ?",
                    "9 × 3 = ?",
                    "25 - 10 = ?",
                    "36 ÷ 6 = ?",
                    "15 + 15 = ?"
                )

                answers = arrayOf(
                    "20",
                    "27",
                    "15",
                    "6",
                    "30"
                )

            } else {

                questions = arrayOf(
                    "Square root of 81?",
                    "15 × 12 = ?",
                    "100 ÷ 4 = ?",
                    "45 + 55 = ?",
                    "90 - 27 = ?"
                )

                answers = arrayOf(
                    "9",
                    "180",
                    "25",
                    "100",
                    "63"
                )
            }
        }

        // =========================
        // SCIENCE
        // =========================

        else if (subject == "Science") {

            if (level == "Easy") {

                questions = arrayOf(
                    "Planet we live on?",
                    "Gas humans breathe?",
                    "H2O is?",
                    "Star near Earth?",
                    "Force pulling objects?"
                )

                answers = arrayOf(
                    "Earth",
                    "Oxygen",
                    "Water",
                    "Sun",
                    "Gravity"
                )

            } else if (level == "Medium") {

                questions = arrayOf(
                    "Center of atom?",
                    "Chemical symbol of Oxygen?",
                    "Largest planet?",
                    "Plants prepare food by?",
                    "Human blood color?"
                )

                answers = arrayOf(
                    "Nucleus",
                    "O",
                    "Jupiter",
                    "Photosynthesis",
                    "Red"
                )

            } else {

                questions = arrayOf(
                    "SI unit of force?",
                    "Nearest galaxy?",
                    "Speed of light unit?",
                    "Inventor of bulb?",
                    "Acid in lemon?"
                )

                answers = arrayOf(
                    "Newton",
                    "Andromeda",
                    "m/s",
                    "Edison",
                    "Citric Acid"
                )
            }
        }

        // =========================
        // ENGLISH
        // =========================

        else {

            if (level == "Easy") {

                questions = arrayOf(
                    "Plural of child?",
                    "Opposite of hot?",
                    "Past tense of go?",
                    "How many vowels?",
                    "What is noun?"
                )

                answers = arrayOf(
                    "Children",
                    "Cold",
                    "Went",
                    "5",
                    "Naming word"
                )

            } else if (level == "Medium") {

                questions = arrayOf(
                    "Synonym of happy?",
                    "Antonym of big?",
                    "Verb in sentence?",
                    "Correct spelling?",
                    "Past tense of eat?"
                )

                answers = arrayOf(
                    "Joyful",
                    "Small",
                    "Running",
                    "Beautiful",
                    "Ate"
                )

            } else {

                questions = arrayOf(
                    "Figure of speech?",
                    "Meaning of metaphor?",
                    "Opposite of ancient?",
                    "Collective noun of lions?",
                    "Adjective example?"
                )

                answers = arrayOf(
                    "Simile",
                    "Comparison",
                    "Modern",
                    "Pride",
                    "Beautiful"
                )
            }
        }

        progressBar.max = questions.size

        loadQuestion()

        btnNext.setOnClickListener {

            val selectedId = radioGroup.checkedRadioButtonId

            if (selectedId != -1) {

                val selectedOption =
                    findViewById<RadioButton>(selectedId)

                if (selectedOption.text.toString()
                    == answers[currentQuestion]
                ) {
                    score++
                }

                txtScore.text = "Score: $score"

                currentQuestion++

                if (currentQuestion < questions.size) {

                    loadQuestion()

                } else {

                    val intent =
                        Intent(this, ResultActivity::class.java)

                    intent.putExtra("score", score)
                    intent.putExtra("total", questions.size)

                    startActivity(intent)

                    finish()
                }

            } else {

                Toast.makeText(
                    this,
                    "Select an answer",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun loadQuestion() {

        radioGroup.clearCheck()

        txtQuestion.text = questions[currentQuestion]

        // EASY MATHS

        if (questions[currentQuestion] == "2 + 2 = ?") {

            option1.text = "4"
            option2.text = "5"
            option3.text = "6"
            option4.text = "7"
        }

        else if (questions[currentQuestion] == "5 + 3 = ?") {

            option1.text = "8"
            option2.text = "6"
            option3.text = "9"
            option4.text = "10"
        }

        else if (questions[currentQuestion] == "10 - 5 = ?") {

            option1.text = "5"
            option2.text = "2"
            option3.text = "8"
            option4.text = "9"
        }

        else if (questions[currentQuestion] == "3 × 2 = ?") {

            option1.text = "6"
            option2.text = "5"
            option3.text = "7"
            option4.text = "8"
        }

        else if (questions[currentQuestion] == "8 ÷ 2 = ?") {

            option1.text = "4"
            option2.text = "3"
            option3.text = "5"
            option4.text = "6"
        }

        // MEDIUM MATHS

        else if (questions[currentQuestion] == "12 + 8 = ?") {

            option1.text = "20"
            option2.text = "18"
            option3.text = "22"
            option4.text = "24"
        }

        else if (questions[currentQuestion] == "9 × 3 = ?") {

            option1.text = "27"
            option2.text = "21"
            option3.text = "24"
            option4.text = "30"
        }

        else if (questions[currentQuestion] == "25 - 10 = ?") {

            option1.text = "15"
            option2.text = "10"
            option3.text = "12"
            option4.text = "18"
        }

        else if (questions[currentQuestion] == "36 ÷ 6 = ?") {

            option1.text = "6"
            option2.text = "5"
            option3.text = "7"
            option4.text = "8"
        }

        else if (questions[currentQuestion] == "15 + 15 = ?") {

            option1.text = "30"
            option2.text = "25"
            option3.text = "35"
            option4.text = "40"
        }

        // HARD MATHS

        else if (questions[currentQuestion] == "Square root of 81?") {

            option1.text = "9"
            option2.text = "8"
            option3.text = "7"
            option4.text = "6"
        }

        else if (questions[currentQuestion] == "15 × 12 = ?") {

            option1.text = "180"
            option2.text = "160"
            option3.text = "170"
            option4.text = "190"
        }

        else if (questions[currentQuestion] == "100 ÷ 4 = ?") {

            option1.text = "25"
            option2.text = "20"
            option3.text = "30"
            option4.text = "15"
        }

        else if (questions[currentQuestion] == "45 + 55 = ?") {

            option1.text = "100"
            option2.text = "90"
            option3.text = "95"
            option4.text = "110"
        }

        else if (questions[currentQuestion] == "90 - 27 = ?") {

            option1.text = "63"
            option2.text = "61"
            option3.text = "65"
            option4.text = "67"
        }

        // SCIENCE

        else if (questions[currentQuestion] == "Planet we live on?") {

            option1.text = "Earth"
            option2.text = "Mars"
            option3.text = "Venus"
            option4.text = "Jupiter"
        }

        else if (questions[currentQuestion] == "Gas humans breathe?") {

            option1.text = "Oxygen"
            option2.text = "Hydrogen"
            option3.text = "Carbon"
            option4.text = "Helium"
        }

        else if (questions[currentQuestion] == "H2O is?") {

            option1.text = "Water"
            option2.text = "Salt"
            option3.text = "Fire"
            option4.text = "Gas"
        }

        else if (questions[currentQuestion] == "Star near Earth?") {

            option1.text = "Sun"
            option2.text = "Moon"
            option3.text = "Mars"
            option4.text = "Jupiter"
        }

        else if (questions[currentQuestion] == "Force pulling objects?") {

            option1.text = "Gravity"
            option2.text = "Speed"
            option3.text = "Energy"
            option4.text = "Light"
        }

        // ENGLISH

        else if (questions[currentQuestion] == "Plural of child?") {

            option1.text = "Children"
            option2.text = "Childs"
            option3.text = "Childrens"
            option4.text = "Child"
        }

        else if (questions[currentQuestion] == "Opposite of hot?") {

            option1.text = "Cold"
            option2.text = "Warm"
            option3.text = "Heat"
            option4.text = "Fire"
        }

        else if (questions[currentQuestion] == "Past tense of go?") {

            option1.text = "Went"
            option2.text = "Going"
            option3.text = "Gone"
            option4.text = "Goed"
        }

        else if (questions[currentQuestion] == "How many vowels?") {

            option1.text = "5"
            option2.text = "4"
            option3.text = "3"
            option4.text = "6"
        }

        else if (questions[currentQuestion] == "What is noun?") {

            option1.text = "Naming word"
            option2.text = "Action word"
            option3.text = "Joining word"
            option4.text = "Describing word"
        }

        progressBar.progress = currentQuestion + 1

        startTimer()
    }

    private fun startTimer() {

        timer?.cancel()

        timer = object : CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {

                txtTimer.text =
                    "Time: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {

                txtTimer.text = "Time Over"

                currentQuestion++

                if (currentQuestion < questions.size) {

                    loadQuestion()

                } else {

                    val intent =
                        Intent(this@QuizActivity, ResultActivity::class.java)

                    intent.putExtra("score", score)
                    intent.putExtra("total", questions.size)

                    startActivity(intent)

                    finish()
                }
            }
        }

        timer?.start()
    }
}