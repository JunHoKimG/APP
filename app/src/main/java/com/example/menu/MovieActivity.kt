package com.example.menu

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie)

        val spGeneros = findViewById<Spinner>(R.id.spGeneros)
        val btnRecomendar = findViewById<Button>(R.id.btnRecomendar)
        val tvRecomendacion = findViewById<TextView>(R.id.tvRecomendacion)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        val generos = arrayOf(
            "Selecciona un género",
            "Acción",
            "Comedia",
            "Ciencia ficción",
            "Terror",
            "Romance",
            "Drama",
            "Fantasía"
        )

        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            generos
        )

        adaptador.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spGeneros.adapter = adaptador

        btnRecomendar.setOnClickListener {
            val generoSeleccionado = spGeneros.selectedItem.toString()

            val recomendacion = when (generoSeleccionado) {
                "Acción" -> "Recomendación: Mad Max: Fury Road"
                "Comedia" -> "Recomendación: Superbad"
                "Ciencia ficción" -> "Recomendación: Interestelar"
                "Terror" -> "Recomendación: El conjuro"
                "Romance" -> "Recomendación: Diario de una pasión"
                "Drama" -> "Recomendación: Sueño de fuga"
                "Fantasía" -> "Recomendación: El señor de los anillos"
                else -> "Selecciona un género de película"
            }

            tvRecomendacion.text = recomendacion
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}