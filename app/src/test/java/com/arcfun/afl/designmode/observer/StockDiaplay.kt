package com.arcfun.afl.designmode.observer

import java.util.*


/**
 * 观察者
 */
class StockDiaplay : Observer {
    override fun update(o: Observable?, arg: Any?) {
        if (o is StockUpdate){
            println("The lastest stock price is ${arg}")
        }
    }
}