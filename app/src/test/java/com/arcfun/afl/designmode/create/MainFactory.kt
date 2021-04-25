package com.arcfun.afl.designmode.create

import org.junit.Test

class MainFactory {

    @Test
    public fun TestFactoryMain() {
        val dellFactroy = AbstructFactory<Dell>()
        val dell = dellFactroy.product()
    }
}