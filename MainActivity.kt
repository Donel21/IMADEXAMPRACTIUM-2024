package com.example.imadpracticumexam2024

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)
        val nextButton = findViewById<Button>(R.id.nxtButton)
        val exitButton = findViewById<Button>(R.id.extButton)


        nextButton.setOnClickListener {
            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


        exitButton.setOnClickListener {
            finishAffinity() // This will close the app completely

        }
    }
}
