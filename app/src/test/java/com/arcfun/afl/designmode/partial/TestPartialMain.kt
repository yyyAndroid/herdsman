package com.arcfun.afl.designmode.partial

import org.junit.Test

class TestPartialMain {


    @Test
    fun test() {
          var applyChain //
                : PartialFunction<ApplyEvent, Unit>
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
        val list = mutableListOf(groupLeader, pressident)
        applyChain = list[0] orElse list[1]
        System.out.println(" ${pressident::class.java}")

        applyChain.invoke(ApplyEvent(200, "hold a"))
    }
}