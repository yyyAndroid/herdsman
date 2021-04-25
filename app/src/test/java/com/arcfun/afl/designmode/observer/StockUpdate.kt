package com.arcfun.afl.designmode.observer

import java.util.*


/**
 * 可观察的，被观察者
 */
class StockUpdate : Observable() {

    val observers = mutableSetOf<Observer>()

    fun setStockChanged(price: Int) {
        this.observers.forEach {
            it.update(this, price)
        }
    }
}