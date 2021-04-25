package com.arcfun.library.kotlin.unit1

fun main(args: Array<String>) {
    val temp1 = 0xF0
    val temp2 = 0x71
    val temp3 = 0x18
//    15, 113, 24
    //0, 24, 18
    //0, 15, 113
    var t = 0
    ++t
    println(t)
    print(((0 and 0xFF).shl(16) + (15 and 0xFF).shl(8) + (113 and 0xFF)) / 100.0)
}