package com.arcfun.afl.designmode.observer

import org.junit.Test

class TestObserverMain {

    @Test
    fun test(){
        val su = StockUpdate()
        val sd = StockDiaplay()
        su.observers.add(sd)
        su.setStockChanged(100)


        val su2 = StockUpdate2()
        val sd2 = StockDisplay2()
        println("-->  ${su2.price}")
        su2.listeners.add(sd2)
        su2.price = 200
        su2.price = -100

    }
}