package com.example.myapplication.ui.inicio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R

class ListaProveedoresFragment : Fragment() {

    private lateinit var proveedorViewModel: ProveedorViewModel
    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_lista_proveedores, container, false)

        listView = root.findViewById(R.id.listViewProveedores)

        // Inicializar el ViewModel
        proveedorViewModel = ViewModelProvider(requireActivity())[ProveedorViewModel::class.java]

        // Observar la lista de proveedores
        proveedorViewModel.proveedores.observe(viewLifecycleOwner) { proveedores ->
            // Actualizar el ListView con la lista de proveedores
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, proveedores.map { it.nombre })
            listView.adapter = adapter
        }

        return root
    }
}
