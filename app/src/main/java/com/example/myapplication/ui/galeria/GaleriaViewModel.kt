package com.example.myapplication.ui.galeria

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GaleriaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is galeria Fragment"
    }
    val text: LiveData<String> = _text
}
