package com.example.myapplication.ui.cliente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R

class ClienteFragment : Fragment() {

    private lateinit var clienteViewModel: ClienteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        clienteViewModel =
            ViewModelProvider(this).get(ClienteViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_cliente, container, false)
        // Configura la vista aquí
        return root
    }
}
