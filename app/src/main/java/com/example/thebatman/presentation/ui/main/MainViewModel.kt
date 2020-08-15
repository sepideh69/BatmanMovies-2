package com.example.thebatman.presentation.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    var toolbarTitle = MutableLiveData<String>()
    fun setToolbarTitle(title: String) {

        toolbarTitle.value = title
        Log.d("ret", "setToolbarTitle : ${toolbarTitle.value}")
    }

    init {
        Log.d("ret", "main vm")
    }
}