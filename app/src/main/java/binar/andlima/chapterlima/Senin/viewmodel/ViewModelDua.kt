package binar.andlima.chapterlima.Senin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelDua : ViewModel(){

    var angka = 0

    val addNumber : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val lessNumber : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}