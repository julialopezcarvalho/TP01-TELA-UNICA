package com.example.app01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNome = findViewById<EditText>(R.id.etNome)
        val etIdade = findViewById<EditText>(R.id.etIdade)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnEntrar.setOnClickListener {
            val nome = etNome.text.toString().trim()
            val idade = etIdade.text.toString().trim().toIntOrNull()

            tvResultado.text = when {
                nome.isEmpty() -> "Por favor, digite seu nome."
                idade == null -> "Por favor, digite uma idade válida."
                else -> "Bem-vindo(a), $nome!\nVocê tem $idade anos."
            }
        }
    }
}
