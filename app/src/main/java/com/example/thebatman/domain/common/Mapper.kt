package com.example.thebatman.domain.common

abstract class Mapper<E ,T> {

    abstract fun mapFrom(from : E) : T
}