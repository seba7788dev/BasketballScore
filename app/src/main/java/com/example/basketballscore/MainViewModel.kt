package com.example.basketballscore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    var _localScore:MutableLiveData<Int> = MutableLiveData()
    var _visitorScore:MutableLiveData<Int> = MutableLiveData()

    val localScore:LiveData<Int>
    get() = _localScore

    val visitorScore:LiveData<Int>
    get() = _visitorScore


    init {
        resetScore()
    }



    fun resetScore(){
        _localScore.value=0
        _visitorScore.value=0
    }

    fun addPointToScore(points:Int,isLocal:Boolean){
        if (isLocal){
            _localScore.value = _localScore.value!! + points
        }else{
            _visitorScore.value = _visitorScore.value!! + points
        }

    }

    fun decreaseLocalScore(){
        if (_localScore.value!! >0){
            _localScore.value = _localScore.value!! - 1
        }
    }

    fun decreaseVisitorScore(){
        if (_visitorScore.value!! >0){
            _visitorScore.value = _visitorScore.value!! - 1
        }
    }
}