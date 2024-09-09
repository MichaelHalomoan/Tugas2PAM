package com.example.tugas2pam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvStudentInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvResult = findViewById(R.id.tvResult)
        tvStudentInfo = findViewById(R.id.tvStudentInfo)

        val result = intent.getDoubleExtra("result", 0.0)
        tvResult.text = "Hasil: $result"
    }
}