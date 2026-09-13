package com.example.euro_dollar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.euro_dollar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            // Get the value from the EditText
            val regex: String = "^[0-9]+(\\.[0-9]+)?\$"
            if (!binding.editTextEuros.text.toString().trim().matches(regex.toRegex())) {
                binding.editTextEuros.error = "Enter a valid number"
                return@setOnClickListener
            }else{
                val euros:Double = binding.editTextEuros.text.toString().toDouble()

                val dollars:Double = String.format("%.2f", euros * 1.09).toDouble()

                binding.textDolars.text = "$dollars $"
            }


        }
    }
}