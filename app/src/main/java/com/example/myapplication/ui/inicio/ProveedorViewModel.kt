package com.example.myapplication.ui.inicio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProveedorViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Proveedor Fragment"
    }
    val text: LiveData<String> = _text
}
