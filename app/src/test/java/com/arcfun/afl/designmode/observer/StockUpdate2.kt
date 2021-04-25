package com.arcfun.afl.designmode.observer

import kotlin.properties.Delegates

class StockUpdate2 {
    var listeners = mutableSetOf<StockUpdate2Listener>()

    var price: Int by Delegates.observable(0) { name, old, new ->
        println("属性名称 - ${name.name}")
        listeners.forEach {
            if (new > old) it.onRise(price) else it.onFall(price)
        }
    }
}