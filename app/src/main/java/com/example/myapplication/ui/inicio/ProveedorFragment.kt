package com.example.myapplication.ui.inicio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentProveedorBinding

class ProveedorFragment : Fragment() {

    private var _binding: FragmentProveedorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inicializar el ViewModel
        val proveedorViewModel = ViewModelProvider(requireActivity())[ProveedorViewModel::class.java]

        // Inflar el layout usando View Binding
        _binding = FragmentProveedorBinding.inflate(inflater, container, false)

        // Configurar el TextView para mostrar texto desde el ViewModel
        proveedorViewModel.text.observe(viewLifecycleOwner) { newText ->
            binding.textProveedor.text = newText
        }

        // Configurar el clic del botón Guardar
        binding.buttonGuardarProveedor.setOnClickListener {
            val nombre = binding.editTextNombreProveedor.text.toString()
            val direccion = binding.editTextDireccionProveedor.text.toString()
            val contacto = binding.editTextContactoProveedor.text.toString()
            val telefono = binding.editTextTelefonoProveedor.text.toString()

            // Crear un nuevo proveedor y agregarlo al ViewModel
            val proveedor = Proveedor(nombre, direccion, contacto, telefono)
            proveedorViewModel.agregarProveedor(proveedor)

            Toast.makeText(requireContext(), "Proveedor guardado: $nombre", Toast.LENGTH_SHORT).show()
        }

        // Configurar el clic del botón Ver Proveedores
        binding.buttonVerProveedores.setOnClickListener {
            val listaProveedoresFragment = ListaProveedoresFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, listaProveedoresFragment)
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Limpiar el binding para evitar fugas de memoria
    }
}
