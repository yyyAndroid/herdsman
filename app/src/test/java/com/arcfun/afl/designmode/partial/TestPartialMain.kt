package com.arcfun.afl.designmode.partial

import org.junit.Test

class TestPartialMain {

    @Test
    fun test() {
        val groupLeader = {
            val definetAt: (ApplyEvent) -> Boolean = { it.money <= 200 }
            val handler: (ApplyEvent) -> Unit = {
                println("Group Leader handled application")
            }
            PartialFunction(definetAt, handler)
        }()

        val pressident = {
            val definetAt: (ApplyEvent) -> Boolean = { it.money <= 500 }
            val handler: (ApplyEvent) -> Unit = {
                println("pressident handled applicaton")
            }
            PartialFunction(definetAt, handler)
        }()

        val applyChain = groupLeader orElse pressident

        applyChain(ApplyEvent(400, "hold a"))
    }
}