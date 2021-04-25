package com.arcfun.library.kotlin.unit1

/**
 * 解构
 * operator
 */
class User(var age: Int, var name: String) {
    operator fun component1() = age
    operator fun component2() = name
}