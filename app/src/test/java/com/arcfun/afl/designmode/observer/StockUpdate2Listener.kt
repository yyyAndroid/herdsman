package com.arcfun.afl.designmode.observer

interface StockUpdate2Listener {
    fun onRise(price : Int)
    fun onFall(price : Int)
}