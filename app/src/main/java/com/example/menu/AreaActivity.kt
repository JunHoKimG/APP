package com.example.menu

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AreaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_area)

        val Lado1=findViewById<EditText>(R.id.etLado1)
        val Lado2=findViewById<EditText>(R.id.etLado2)
        val btnCalcular=findViewById<Button>(R.id.btnCalcular)
        val tvResultado=findViewById<TextView>(R.id.tvResultado)
        val btnRegresar=findViewById<Button>(R.id.btnRegresar)

        btnCalcular.setOnClickListener {
            val base=Lado1.text.toString().toDoubleOrNull()
            val altura=Lado2.text.toString().toDoubleOrNull()

            if(base != null && altura != null) {
                val area=base*altura
                tvResultado.text = "Área = $area"
            }
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}