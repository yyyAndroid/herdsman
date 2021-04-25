package com.arcfun.afl

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class OutLibViewModel(application: Application) : AndroidViewModel(application){
    val outputState: MutableLiveData<Boolean> = MutableLiveData()
    val outputNum: MutableLiveData<Int> = MutableLiveData()

}