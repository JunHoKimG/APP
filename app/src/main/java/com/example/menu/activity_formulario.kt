package com.example.menu

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val spinnerCarrera = findViewById<Spinner>(R.id.spinnerCarrera)
        val rgTurno = findViewById<RadioGroup>(R.id.rgTurno)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val tvResumen = findViewById<TextView>(R.id.tvResumen)
        val btnVolver = findViewById<Button>(R.id.btnVolverMenuFormulario)

        // Carreras del Spinner
        val carreras = arrayOf(
            "Selecciona una carrera",
            "Sistemas Embebidos",
            "Mecatrónica",
            "Industrial",
            "Diseño Industrial"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            carreras
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinnerCarrera.adapter = adapter

        // Botón Mostrar información
        btnMostrar.setOnClickListener {

            val nombre = etNombre.text.toString().trim()
            val carrera = spinnerCarrera.selectedItem.toString()

            // Validar nombre
            if (nombre.isEmpty()) {
                etNombre.error = "Ingresa tu nombre"
                etNombre.requestFocus()
                return@setOnClickListener
            }

            // Validar carrera
            if (spinnerCarrera.selectedItemPosition == 0) {
                Toast.makeText(
                    this,
                    "Selecciona una carrera",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Validar turno
            val turnoId = rgTurno.checkedRadioButtonId

            if (turnoId == -1) {
                Toast.makeText(
                    this,
                    "Selecciona un turno",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Obtener nombre del RadioButton seleccionado
            val radioButton = findViewById<android.widget.RadioButton>(turnoId)
            val turno = radioButton.text.toString()

            // Mostrar resumen
            tvResumen.text = """
                Información del alumno:
                
                Nombre: $nombre
                Carrera: $carrera
                Turno: $turno
            """.trimIndent()
        }

        // Botón volver al menú
        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}