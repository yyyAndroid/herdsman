package com.arcfun.afl.designmode.strategy

class SwimmerK(val swimmer: () -> Unit) {
    fun swim() {
        swimmer()
    }
}