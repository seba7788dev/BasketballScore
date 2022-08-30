package com.example.basketballscore

import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
     var localScore=0
     var visitorScore=0

    fun resetScore(){
        localScore=0
        visitorScore=0
    }

    fun addPointToScore(points:Int,isLocal:Boolean){
        if (isLocal){
            localScore += points
        }else{
            visitorScore += points
        }

    }

    fun decreaseLocalScore(){
        if (localScore>0){
            localScore--
        }
    }

    fun decreaseVisitorScore(){
        if (visitorScore>0){
            visitorScore--
        }
    }
}