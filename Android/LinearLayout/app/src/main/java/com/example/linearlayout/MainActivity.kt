package com.example.linearlayout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.linearlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonReais.setOnClickListener {
            // Get the value from the EditText
            val regex: String = "^[0-9]+(\\.[0-9]+)?\$"
            if (!binding.editTextEuros.text.toString().trim().matches(regex.toRegex())) {
                binding.editTextEuros.error = "Insere um valor válido"
                return@setOnClickListener
            }else{
                val euros:Double = binding.editTextEuros.text.toString().toDouble()

                val reais:Double = String.format("%.2f", euros * 4.4).toDouble()

                binding.textResultado.text = "$reais R$"
                Toast.makeText(this, "$reais R$", Toast.LENGTH_SHORT).show()
            }
        }
        binding.buttonDollars.setOnClickListener {
            // Get the value from the EditText
            val regex: String = "^[0-9]+(\\.[0-9]+)?\$"
            if (!binding.editTextEuros.text.toString().trim().matches(regex.toRegex())) {
                binding.editTextEuros.error = "Insere um valor válido"
                return@setOnClickListener
            }else{
                val euros:Double = binding.editTextEuros.text.toString().toDouble()

                val dollars:Double = String.format("%.2f", euros * 1.20).toDouble()

                binding.textResultado.text = "$dollars $"
                Toast.makeText(this, "$dollars \$", Toast.LENGTH_SHORT).show()
            }
        }
        binding.buttonPesos.setOnClickListener {
            // Get the value from the EditText
            val regex: String = "^[0-9]+(\\.[0-9]+)?\$"
            if (!binding.editTextEuros.text.toString().trim().matches(regex.toRegex())) {
                binding.editTextEuros.error = "Insere um valor válido"
                return@setOnClickListener
            }else{
                val euros:Double = binding.editTextEuros.text.toString().toDouble()

                val pesos:Double = String.format("%.2f", euros * 31.5).toDouble()

                binding.textResultado.text = "$pesos \$Pesos"
                Toast.makeText(this, "$pesos \$Pesos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}