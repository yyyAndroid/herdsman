package com.arcfun.afl.designmode.observer

class StockDisplay2 : StockUpdate2Listener {
    override fun onRise(price: Int) {
        println("The lastest stock price has risen to ${price}")
    }

    override fun onFall(price: Int) {
        println("The lastest stock print has fell to ${price}")
    }
}