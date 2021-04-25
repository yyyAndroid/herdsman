package com.arcfun.afl

class Hello {
    @JvmField var name = "";

    constructor(){
        println("hello constructor")
    }

    init {
        println("hello init")
    }
}