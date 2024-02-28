package com.example.calculatrice

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber1)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val spinnerOperation = findViewById<Spinner>(R.id.spinnerOperation)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        // Définition des opérations disponibles
        val operations = arrayOf("+", "-", "*", "/")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOperation.adapter = adapter

        buttonCalculate.setOnClickListener {
            val number1 = editTextNumber1.text.toString().toDouble()
            val number2 = editTextNumber2.text.toString().toDouble()
            val operation = spinnerOperation.selectedItem.toString()

            val result = when (operation) {
                "+" -> number1 + number2
                "-" -> number1 - number2
                "*" -> number1 * number2
                "/" -> {
                    if (number2 == 0.0) {
                        "Error: Division by zero"
                    } else {
                        number1 / number2
                    }
                }
                else -> "Invalid operation"
            }

            textViewResult.text = "Result: $result"
        }
    }
}
