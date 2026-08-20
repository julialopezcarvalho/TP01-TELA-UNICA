package com.example.app02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etCelsius = findViewById<EditText>(R.id.etCelsius)
        val btnConverter = findViewById<Button>(R.id.btnConverter)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnConverter.setOnClickListener {
            // troca vírgula por ponto para aceitar "36,5" além de "36.5"
            val texto = etCelsius.text.toString().trim().replace(",", ".")
            val celsius = texto.toDoubleOrNull()

            if (celsius == null) {
                tvResultado.text = "Digite uma temperatura válida."
            } else {
                val fahrenheit = celsius * 9 / 5 + 32
                tvResultado.text = String.format(
                    Locale.getDefault(),
                    "%.2f °C  =  %.2f °F",
                    celsius,
                    fahrenheit
                )
            }
        }
    }
}
