package com.arcfun.afl.designmode.partial

import java.lang.IllegalArgumentException

/**
 * kotlin 的责任链模式,利用偏函数
 * deinetAt为校验函数
 * f为处理函数
 */
class PartialFunction<in P1, out R>(
    private val definetAt: (P1) -> Boolean,//变量defineAt是一个传入阐述为P1 返回为Boolean的成员变量
    private val f: (P1) -> R
) : (P1) -> R {
    override fun invoke(p1: P1): R {
        if (definetAt(p1)) {
            return f(p1)
        } else {
            throw IllegalArgumentException("Value isn't supported by this function")
        }
    }

    fun isDefineAt(p1: P1) = definetAt(p1)
}

infix fun <P1, R> PartialFunction<P1, R>.orElse(that: PartialFunction<P1, R>):
        PartialFunction<P1, R> {
    return PartialFunction({ this.isDefineAt(it) || that.isDefineAt(it) }) {
        when {
            this.isDefineAt(it) -> this(it)
            else -> that(it)
        }
    }
}

data class ApplyEvent(val money : Int, val title : String)
