package com.example.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.basketballscore.databinding.ActivityMainBinding

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
            sumarUnPuntoLocal(binding.localPuntos)
        }

        binding.localMasDos.setOnClickListener {
            sumarDosPuntosLocal(binding.localPuntos)
        }

        binding.visitanteMasUno.setOnClickListener {

            sumarUnPuntoVisita(binding.visitantePuntos)

        }

        binding.visitanteMasDos.setOnClickListener {

            sumarDosPuntosVisita(binding.visitantePuntos)
        }

        binding.btnSiguiente.setOnClickListener {
            val intent = Intent(this, FinalResultActivity::class.java)
            startActivity(intent)
        }
    }
    fun sumarUnPuntoLocal(textView: TextView){
        localPuntos+=1
        textView.text=localPuntos.toString()

    }
    fun sumarDosPuntosLocal(textView: TextView){
        localPuntos+=2
        textView.text=localPuntos.toString()

    }

    fun sumarUnPuntoVisita(textView: TextView){
        visitantePuntos+=1
        textView.text=visitantePuntos.toString()

    }

    fun sumarDosPuntosVisita(textView: TextView){
        visitantePuntos+=2
        textView.text=visitantePuntos.toString()

    }



    //funca para el orto
    fun sumarPuntos(textView: TextView,cantPuntos:Int, localOVisita:Int){
        var cantidadPuntos=cantPuntos
        var localia=localOVisita

        localia+=cantidadPuntos
        textView.text=localia.toString()
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