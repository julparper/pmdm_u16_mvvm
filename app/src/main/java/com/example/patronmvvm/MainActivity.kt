package com.example.patronmvvm


import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.patronmvvm.databinding.ActivityMainBinding
import com.example.patronmvvm.model.PersonaModel
import com.example.patronmvvm.viewmodel.PersonaViewModel

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private val personaViewModel: PersonaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Conectamos los text view y el modelo usando el viewModel
        personaViewModel.personaModel.observe(this, Observer { persona ->
            binding.tvNombre.text = persona.nombre
            binding.tvApellidos.text = persona.apellidos
        })

        binding.btnActualizar.setOnClickListener(this)
    }

    /* Llamamos al proveedor de datos y refrescamos el modelo del viewModel
        observa que no se vuelve a tocar nada de la actividad, solo se modifican los datos
        y al hacerlo se modifican los datos de la UI
     */
    override fun onClick(v: View?) {
        //Cargo otra persona en el viewModel
        personaViewModel.leerPersona()
    }
}