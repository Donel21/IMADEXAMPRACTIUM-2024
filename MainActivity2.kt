package com.example.imadpracticumexam2024

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    private val minimumTemp = IntArray(7)
    private val maximumTemp= IntArray(7)
    private val dates = Array(7) { "" }
    private val  weatherCondition = Array(7) { "" }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainscreen)

        val minimumInput = findViewById<EditText>(R.id.minimumInput)
        val maximumInput = findViewById<EditText>(R.id.maximumInput)
        val dayInput = findViewById<EditText>(R.id.dayInput)
        val weatherConditionInput = findViewById<TextView>(R.id.weatherConditionInput)

        val saveButton = findViewById<Button>(R.id.saveButton)
        val detailedDailyViewButton = findViewById<Button>(R.id.detailedDailyViewButton)
        val clearButton = findViewById<Button>(R.id.clearButton)

        saveButton.setOnClickListener {
            val index = getFirstEmptyIndex()
            if (index != -1) {
                val minimumValue = minimumInput.text.toString().toIntOrNull()
                val maximumValue = maximumInput.text.toString().toIntOrNull()

                if (minimumValue== null || maximumValue == null) {
                    Toast.makeText(
                        this,
                        "Please enter valid numbers for screen time",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    minimumTemp[index] = minimumValue
                    maximumTemp[index] = maximumValue
                    dates[index] = dayInput.text.toString()
                    weatherCondition[index] = weatherConditionInput.text.toString()

                    Toast.makeText(this, "Data saved for day ${index + 1}", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(this, "All 7 days are already filled", Toast.LENGTH_SHORT).show()
            }
        }

        clearButton.setOnClickListener {
            minimumInput.setText("")
            maximumInput.setText("")
            dayInput.setText("")
            weatherConditionInput.text = ""
        }

        detailedDailyViewButton.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("MinimumArray", minimumTemp)
            intent.putExtra("MaximumArray", maximumTemp)
            intent.putExtra("datesArray", dates)
            intent.putExtra("weatherConditionArray", weatherCondition)
            startActivity(intent)
        }
    }

    private fun getFirstEmptyIndex(): Int {
        for (i in minimumTemp.indices) {
            if (minimumTemp[i] == 0 && maximumTemp[i] == 0 && dates[i].isEmpty() && weatherCondition[i].isEmpty()) {
                return i
            }
        }
        return -1
    }
}
