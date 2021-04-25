package com.arcfun.afl.designmode.create

open abstract class AbstructFactory {

    abstract fun product(): Computer

    /**
     * 利用 operator 与 reified 编写抽象工厂
     */
    companion object {
        inline operator fun <reified T : Computer> invoke(): AbstructFactory {
            return when (T::class) {
                Dell::class -> DellFactroy()
                else -> DellFactroy()
            }
        }
    }
}