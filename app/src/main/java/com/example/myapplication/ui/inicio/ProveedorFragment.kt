package com.example.myapplication.ui.proveedor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentProveedorBinding
import com.example.myapplication.ui.inicio.ProveedorViewModel

class ProveedorFragment : Fragment() {

    private var _binding: FragmentProveedorBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val proveedorViewModel =
            ViewModelProvider(this).get(ProveedorViewModel::class.java)

        _binding = FragmentProveedorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textProveedor
        proveedorViewModel.text.observe(viewLifecycleOwner) { newText ->
            textView.text = newText
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
