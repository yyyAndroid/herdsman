package com.arcfun.afl.designmode.strategy

class SwimmerGeneral(val swimStrategyGeneral: SwimStrategyGeneral) {
    fun swim() {
        swimStrategyGeneral.swim()
    }
}