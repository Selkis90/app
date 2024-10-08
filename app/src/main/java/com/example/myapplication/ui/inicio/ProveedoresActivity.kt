package com.example.myapplication.ui.inicio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityProveedoresBinding

class ProveedoresActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProveedoresBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProveedoresBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar los datos guardados en SharedPreferences
        val sharedPref = getSharedPreferences("MiPreferencia", MODE_PRIVATE)
        val nombreGuardado = sharedPref.getString("nombre", "N/A")
        val estadoSesion = sharedPref.getBoolean("isLoggedIn", false)

        // Mostrar los datos en la UI
        binding.textViewNombre.text = "Nombre: $nombreGuardado"
        binding.textViewEstadoSesion.text = "Sesión iniciada: $estadoSesion"
    }
}
