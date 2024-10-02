package com.example.myapplication.ui.inicio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProveedorViewModel : ViewModel() {

    // MutableLiveData para almacenar el texto
    private val _text = MutableLiveData<String>().apply {
        value = ""
    }
    val text: LiveData<String> = _text

    // MutableLiveData para almacenar la lista de proveedores
    private val _proveedores = MutableLiveData<MutableList<Proveedor>>(mutableListOf())
    val proveedores: LiveData<MutableList<Proveedor>> get() = _proveedores

    // Método para agregar un proveedor
    fun agregarProveedor(proveedor: Proveedor) {
        _proveedores.value?.add(proveedor)
        _proveedores.value = _proveedores.value // Notificar cambios
    }
}
