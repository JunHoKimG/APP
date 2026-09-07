package com.example.menu

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnArea=findViewById<Button>(R.id.btnArea)
        btnArea.setOnClickListener {
            val intent=Intent(this,AreaActivity::class.java)
            startActivity(intent)
        }

        val btnPeliculas = findViewById<Button>(R.id.btnPeliculas)

        btnPeliculas.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }
    }
}