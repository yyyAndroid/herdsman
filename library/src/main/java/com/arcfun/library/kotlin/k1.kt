package com.arcfun.library.kotlin

import com.arcfun.library.kotlin.unit1.User

class k1 {
    val res = listOf(1, 2, 4, 3)
    val mls = mutableListOf<Int>()
    val a = 1
    fun go() {

        val user = User(18, "nick")

        val result = res.reduce { total, next -> total + next }

        println("结果$result")

        user.let { a : User -> "hellow" }

        res.forEachIndexed { index, i ->
            val a = 1;
            println("$index - ${i + a}")
        }

        val max = res.max()
        println("最大的一项$max")

        val minBy = res.maxBy { it - 1 }
        println("maxBy $minBy")


        res.take(3).forEach {
            println("$it  ")
        }
        res.takeWhile { it > 0 }

        res.map { 1 + it }.forEach { print(it) }

        println()
        res.groupBy { if (it > 2) "A" else "B" }.forEach {
            print("${it.key}  ${it.value}")
        }
        println("")


        res?.let {
            it[2]
        }.takeIf {
            it == 1
        }
            ?.run {
                println("takeif结果：${this}")
            }


    }
}