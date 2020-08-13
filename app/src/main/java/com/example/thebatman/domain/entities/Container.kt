package com.example.thebatman.domain.entities

data class Container<T>(private val value : T ? =null) {

    companion object{

        fun <T> of(value : T) : Container<T>{
            return Container(value)
        }
        fun <T> empty(): Container<T> {
            return Container()
        }
    }

    fun hasValue() : Boolean{
        return value!=null
    }
}