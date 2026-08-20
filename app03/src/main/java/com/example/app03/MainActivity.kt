package com.example.app03

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

        val etTensao = findViewById<EditText>(R.id.etTensao)
        val etResistencia = findViewById<EditText>(R.id.etResistencia)
        val etCorrente = findViewById<EditText>(R.id.etCorrente)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // função de extensão: lê o campo e devolve null se estiver vazio/inválido
        fun EditText.valor(): Double? =
            text.toString().trim().replace(",", ".").toDoubleOrNull()

        btnCalcular.setOnClickListener {
            val v = etTensao.valor()
            val r = etResistencia.valor()
            val i = etCorrente.valor()

            tvResultado.text = when {
                // recebeu resistência e corrente -> calcula tensão
                v == null && r != null && i != null ->
                    formatar("Tensão (V)", r * i, "V")

                // recebeu tensão e corrente -> calcula resistência
                r == null && v != null && i != null ->
                    if (i == 0.0) "A corrente não pode ser zero."
                    else formatar("Resistência (R)", v / i, "Ω")

                // recebeu tensão e resistência -> calcula corrente
                i == null && v != null && r != null ->
                    if (r == 0.0) "A resistência não pode ser zero."
                    else formatar("Corrente (I)", v / r, "A")

                else ->
                    "Preencha exatamente DOIS campos com valores válidos."
            }
        }

        btnLimpar.setOnClickListener {
            etTensao.text.clear()
            etResistencia.text.clear()
            etCorrente.text.clear()
            tvResultado.text = ""
        }
    }

    private fun formatar(nome: String, valor: Double, unidade: String): String =
        String.format(Locale.getDefault(), "%s = %.2f %s", nome, valor, unidade)
}
