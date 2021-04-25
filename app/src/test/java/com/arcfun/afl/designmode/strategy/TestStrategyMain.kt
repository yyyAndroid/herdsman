package com.arcfun.afl.designmode.strategy

import org.junit.Test

class TestStrategyMain {

    @Test
    fun test() {
        val swimmer = Swimmer()
        swimmer.swim()

        val swimmerGeneral = SwimmerGeneral(FreeStyleGeneral())
        swimmerGeneral.swim()

        val swimmerK = SwimmerK(::freestyle)
        swimmerK.swim()

    }
}