package com.arcfun.library.kotlin.unit2

fun main(args: Array<String>) {
    val hello = Hello()
    hello.string = "world"
    println(hello.string)
}

class Hello {
    var string: String? = null
        get() {
            return field + "hello"
        }
        set(value) {
            field = value + "set"
        }
}