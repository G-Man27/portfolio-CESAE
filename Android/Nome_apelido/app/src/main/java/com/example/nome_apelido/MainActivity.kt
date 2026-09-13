package com.example.nome_apelido

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nome_apelido.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val apelido = binding.editApelido.text.toString()

            if (nome.isNotEmpty() && apelido.isNotEmpty()) {
                Toast.makeText(applicationContext, "Bom dia, $nome $apelido", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}