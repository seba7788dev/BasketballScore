package com.example.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.basketballscore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModelLayout=viewModel


        viewModel.localScore.observe(this, Observer { localScoreLivedata ->
            binding.localPuntos.text = localScoreLivedata.toString()
        })

        viewModel.visitorScore.observe(this, Observer { visitorScoreLivedata ->
            binding.visitantePuntos.text = visitorScoreLivedata.toString()
        })

        setupButtons()


       //binding.localPuntos.text = localPuntos.toString()
       // binding.visitantePuntos.text = visitantePuntos.toString()



    }
    fun setupButtons() {
        binding.botonRestart.setOnClickListener {
            viewModel.resetScore()

        }

        binding.localMenos.setOnClickListener {
            viewModel.decreaseLocalScore()

        }


        binding.visitanteMenos.setOnClickListener {
        viewModel.decreaseVisitorScore()


        }

        binding.localMasUno.setOnClickListener {
                viewModel.addPointToScore(1,true)

        }

        binding.localMasDos.setOnClickListener {
            viewModel.addPointToScore(2,true)

        }

        binding.visitanteMasUno.setOnClickListener {

            viewModel.addPointToScore(1,false)

        }

        binding.visitanteMasDos.setOnClickListener {

            viewModel.addPointToScore(2,false)

        }

        binding.btnSiguiente.setOnClickListener {
            val intent = Intent(this, FinalResultActivity::class.java)
            intent.putExtra(FinalResultActivity.PUNTAJE_LOCAL, viewModel.localScore.value)
            intent.putExtra(FinalResultActivity.PUNTAJE_VISITA, viewModel.visitorScore.value)
            val mensaje = when {
                viewModel.localScore.value!! > viewModel.visitorScore.value!! -> {
                    "GANO LOCAL"
                }
                viewModel.localScore.value!! < viewModel.visitorScore.value!! -> {
                    "GANO VISITANTE"
                }
                else -> {
                    "EMPATE"
                }
            }
            intent.putExtra(FinalResultActivity.mensajeAMostrar, mensaje)
            startActivity(intent)
        }
    }

}

//***********************************************


/**

class MainActivity : AppCompatActivity() {
var localPuntos:Int=0
var visitantePuntos:Int=0
private lateinit var binding: ActivityMainBinding

override fun onCreate(savedInstanceState: Bundle?) {
binding= ActivityMainBinding.inflate(layoutInflater)
super.onCreate(savedInstanceState)
setContentView(binding.root)


binding.localPuntos.text=localPuntos.toString()
binding.visitantePuntos.text=visitantePuntos.toString()


binding.botonRestart.setOnClickListener {
localPuntos=0
visitantePuntos=0
binding.localPuntos.text=localPuntos.toString()
binding.visitantePuntos.text=visitantePuntos.toString()
}

binding.localMenos.setOnClickListener {
if (binding.localPuntos.text!="0"){
localPuntos-=1
binding.localPuntos.text=localPuntos.toString()

}


}

binding.visitanteMenos.setOnClickListener {
if (binding.visitantePuntos.text!="0"){
visitantePuntos-=1
binding.visitantePuntos.text=visitantePuntos.toString()

}


}

binding.localMasUno.setOnClickListener {
localPuntos+=1
binding.localPuntos.text=localPuntos.toString()
}

binding.localMasDos.setOnClickListener {
localPuntos+=2
binding.localPuntos.text=localPuntos.toString()
}

binding.visitanteMasUno.setOnClickListener {
visitantePuntos+=1
binding.visitantePuntos.text=visitantePuntos.toString()
}

binding.visitanteMasDos.setOnClickListener {
visitantePuntos+=2
binding.visitantePuntos.text=visitantePuntos.toString()
}

binding.btnSiguiente.setOnClickListener {
val intent = Intent(this, FinalResultActivity::class.java)
startActivity(intent)
}
}



}



 *
 *
 * */