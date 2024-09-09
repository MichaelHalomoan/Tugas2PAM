package com.example.tugas2pam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var rbAdd: RadioButton
    private lateinit var rbSubtract: RadioButton
    private lateinit var rbMultiply: RadioButton
    private lateinit var rbDivide: RadioButton
    private lateinit var btnCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        rbAdd = findViewById(R.id.rbAdd)
        rbSubtract = findViewById(R.id.rbSubtract)
        rbMultiply = findViewById(R.id.rbMultiply)
        rbDivide = findViewById(R.id.rbDivide)
        btnCalculate = findViewById(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            val number1 = etNumber1.text.toString().toDouble()
            val number2 = etNumber2.text.toString().toDouble()
            var result = 0.0

            when {
                rbAdd.isChecked -> {
                    result = number1 + number2
                }
                rbSubtract.isChecked -> {
                    result = number1 - number2
                }
                rbMultiply.isChecked -> {
                    result = number1 * number2
                }
                rbDivide.isChecked -> {
                    if (number2 != 0.0) {
                        result = number1 / number2
                    } else {
                        Toast.makeText(this, "Error: Pembagian dengan nol!", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }
                else -> {
                    Toast.makeText(this, "Pilih operasi hitung terlebih dahulu!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("result", result)
            startActivity(intent)
        }
    }
}
