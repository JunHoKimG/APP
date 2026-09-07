package com.example.menu

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class IMC_CALC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_imccalc)

        val etPeso = findViewById<EditText>(R.id.etPeso)
        val etEstatura = findViewById<EditText>(R.id.etEstatura)
        val btnIMC = findViewById<Button>(R.id.btnIMC)
        val btnReg = findViewById<Button>(R.id.btnReg)

        btnIMC.setOnClickListener {

            val peso = etPeso.text.toString().toDoubleOrNull()
            val estatura = etEstatura.text.toString().toDoubleOrNull()

            if (peso == null || peso <= 0) {
                etPeso.error = "Ingresa un peso válido"
                return@setOnClickListener
            }

            if (estatura == null || estatura <= 0) {
                etEstatura.error = "Ingresa una estatura válida"
                return@setOnClickListener
            }

            val imc = peso / (estatura * estatura)

            Toast.makeText(
                this,
                "Tu IMC es: %.2f".format(imc),
                Toast.LENGTH_LONG
            ).show()
        }

        btnReg.setOnClickListener {
            finish()
        }
    }
}