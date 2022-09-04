package com.example.basketballscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basketballscore.databinding.ActivityFinalResultBinding

class FinalResultActivity : AppCompatActivity() {
    companion object{
        const val PUNTAJE_LOCAL="local"
        const val PUNTAJE_VISITA="visita"
        var mensajeAMostrar="msj"
    }
    lateinit var binding: ActivityFinalResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityFinalResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val puntoLocal=intent.getIntExtra(PUNTAJE_LOCAL,0)

        val puntoVisita=intent.getIntExtra(PUNTAJE_VISITA,0)
        val mensaje=intent.getStringExtra(mensajeAMostrar)

        binding.puntajeLocal.text=puntoLocal.toString()
        binding.puntoajeVisita.text=puntoVisita.toString()
        binding.mensajeResultado.text=mensaje


    }
}