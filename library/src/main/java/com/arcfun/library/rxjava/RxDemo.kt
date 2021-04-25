package com.arcfun.library.rxjava

import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import org.reactivestreams.Subscription

fun main(args: Array<String>) {
    val observableString = Observable.create { emitter: ObservableEmitter<Int> ->
        for (index in 1 until 5) {
            emitter.onNext(index)
        }
        emitter.onComplete()
    }

    val subscriptionPrint = observableString.subscribe({
        System.out.println("Item is ${it}")
    }, {}, {
        System.out.println("Observable completed")
    })
}