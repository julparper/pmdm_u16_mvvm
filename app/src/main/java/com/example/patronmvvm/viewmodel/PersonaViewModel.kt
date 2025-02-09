package com.example.patronmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.patronmvvm.model.PersonaModel
import com.example.patronmvvm.model.PersonaProvider

class PersonaViewModel: ViewModel() {

    val personaModel = MutableLiveData<PersonaModel>()

    fun leerPersona(){
        val persona = PersonaProvider.leer()
        personaModel.postValue(persona)
    }
}