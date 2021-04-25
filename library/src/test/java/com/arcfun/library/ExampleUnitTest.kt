package com.arcfun.library

import org.junit.Test
import java.math.BigDecimal

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val a : Integer = Integer(1)
        val b : Integer = Integer(1)
        println(a == b)
        println(BigDecimal(80).divide(BigDecimal(100)).toFloat())
    }
}