package com.arcfun.afl;

import com.arcfun.afl.designmode.create.AbstructFactory
import com.arcfun.afl.designmode.create.Dell
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 * <p>
 * See [testing documentation](http://d.android.com/tools/testing).
 */
public class ExampleUnitTest {

    @Test
    fun TestRxjava() = runBlocking {
        val a = async {
            one()
        }
        println("finish1")
        println("one = ${a.await()}")
        println("finish")
    }

    suspend fun one(): String {
        delay(1000L)
        return "one"
    }

    suspend fun two(): String {
        delay(2000L)
        return "two"
    }
}