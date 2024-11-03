package com.example.tourism.ui


import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tourism.R

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val chatButton: ImageButton = findViewById(R.id.chat_button)
        val changeButton: ImageButton = findViewById(R.id.change_button)

        chatButton.setOnClickListener {
            Toast.makeText(this, "Chat Button Pressed", Toast.LENGTH_SHORT).show()
        }

        changeButton.setOnClickListener{
            Toast.makeText(this,"Change Butyon Pressed",Toast.LENGTH_SHORT).show()
        }
    }
}

