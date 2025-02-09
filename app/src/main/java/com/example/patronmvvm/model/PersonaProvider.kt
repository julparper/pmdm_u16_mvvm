package com.example.patronmvvm.model



class PersonaProvider() {


    companion object{
        var pos = 1

        fun leer(): PersonaModel{
            pos = (pos +1) % 2
            return personas[pos]
        }

        private val personas = listOf(
            PersonaModel("Persona 0", "Apellidos Persona 0"),
            PersonaModel("Persona 1", "Apellidos Persona 1")
        )
    }
}