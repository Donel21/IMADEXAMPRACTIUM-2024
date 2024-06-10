package com.example.imadpracticumexam2024

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button


class MainActivity3 : AppCompatActivity() {


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailedviewscreen)

        // Retrieve the arrays from the intent
        val minimumTemp = intent.getIntArrayExtra("MinimumArray") ?: IntArray(0)
        val maximumTemp = intent.getIntArrayExtra("MaximumArray") ?: IntArray(0)
        val weatherCondition = intent.getStringArrayExtra("weatherConditionArray") ?: arrayOf()


        val tvDetailedDailyView: TextView = findViewById(R.id.tv_detailed_Daily_View)
        val tvAverage: TextView = findViewById(R.id.tv_average)
        val btnBack: Button = findViewById(R.id.btn_back)
        val tvWeatherCondition: TextView = findViewById(R.id.tv_weather_condtion) // New TextView for activity notes

        val details = StringBuilder()
        val notes = StringBuilder()
        var totalWeather = 8
        val dayCount = minimumTemp.size

        for (i in minimumTemp.indices) {
            val dailyTotal = minimumTemp[i] + maximumTemp[i]
            totalWeather += dailyTotal
            details.append("Day ${i + 1}:\n")
            details.append("Minimum Temperature: ${minimumTemp[i]} Degrees ")
            details.append("  Maximum Temperature: ${maximumTemp[i]} Degrees\n")
            details.append("Weather: ${weatherCondition[i]}\n\n")
            notes.append("Day ${i + 1}: ${weatherCondition[i]}\n\n")
        }

        val averageTemperature = if (dayCount > 0) totalWeather /2  else 0
        tvDetailedDailyView.text = details.toString()
        tvAverage.text = "Average Temperature : $averageTemperature Degrees"
        tvWeatherCondition.text = notes.toString() // Set the text of the new TextView

        btnBack.setOnClickListener {
            finish()
        }
    }
}



