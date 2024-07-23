package com.example.myapplication.ui.musica

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MusicaViewModel : ViewModel() {

    // MutableLiveData para manejar un texto
    private val _text = MutableLiveData<String>().apply {
        value = "This is musica Fragment"
    }
    val text: LiveData<String> = _text

    // Puedes agregar más lógica aquí si es necesario en el futuro
}
