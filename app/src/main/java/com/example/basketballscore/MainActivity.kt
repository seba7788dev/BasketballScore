package com.example.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basketballscore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var localPuntos:Int=0
    var visitantePuntos:Int=0
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setupButtons()


      //  binding.localPuntos.text = localPuntos.toString()
       // binding.visitantePuntos.text = visitantePuntos.toString()



    }
    fun setupButtons() {
        binding.botonRestart.setOnClickListener {
           resetScore()
            binding.localPuntos.text=localPuntos.toString()
            binding.visitantePuntos.text=visitantePuntos.toString()
        }

        binding.localMenos.setOnClickListener {
            viewModel.decreaseLocalScore()
            binding.localPuntos.text=viewModel.localScore.toString()
        }


        binding.visitanteMenos.setOnClickListener {
        viewModel.decreaseVisitorScore()
            binding.visitantePuntos.text=viewModel.visitorScore.toString()

        }

        binding.localMasUno.setOnClickListener {
                addPointToScore(1,true)
                binding.localPuntos.text=viewModel.localScore.toString()
        }

        binding.localMasDos.setOnClickListener {
            addPointToScore(2,true)
            binding.localPuntos.text=viewModel.localScore.toString()
        }

        binding.visitanteMasUno.setOnClickListener {

            addPointToScore(1,false)
            binding.visitantePuntos.text=viewModel.visitorScore.toString()

        }

        binding.visitanteMasDos.setOnClickListener {

            addPointToScore(2,false)
            binding.visitantePuntos.text=viewModel.visitorScore.toString()

        }

        binding.btnSiguiente.setOnClickListener {
            val intent = Intent(this, FinalResultActivity::class.java)
            intent.putExtra(FinalResultActivity.PUNTAJE_LOCAL, localPuntos)
            intent.putExtra(FinalResultActivity.PUNTAJE_VISITA, visitantePuntos)
            val mensaje = when {
                localPuntos > visitantePuntos -> {
                    "GANO LOCAL"
                }
                localPuntos < visitantePuntos -> {
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

    fun resetScore(){
        viewModel.resetScore()
    }

    fun addPointToScore(points:Int,isLocal:Boolean){

        viewModel.addPointToScore(points,isLocal)
        if (isLocal){
            binding.localPuntos.text
        }else{
            binding.visitantePuntos.text
        }

    }




        fun sumarUnPuntoLocal(textView: TextView) {
            localPuntos += 1
            textView.text = localPuntos.toString()

        }

        fun sumarDosPuntosLocal(textView: TextView) {
            localPuntos += 2
            textView.text = localPuntos.toString()

        }

        fun sumarUnPuntoVisita(textView: TextView) {
            visitantePuntos += 1
            textView.text = visitantePuntos.toString()

        }

        fun sumarDosPuntosVisita(textView: TextView) {
            visitantePuntos += 2
            textView.text = visitantePuntos.toString()

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