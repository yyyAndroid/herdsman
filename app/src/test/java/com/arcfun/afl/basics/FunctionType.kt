package com.arcfun.afl.basics

import android.util.Log
import org.junit.Test
import java.util.*

class FunctionType {

    @Test
    fun test() {
        lambdaVal()
    }


    fun lambdaVal(){
        val sum : (Int, Int) -> Int = {x,y ->
            x + y
            1
        }
        println("${sum(1, 2)}")
    }

    /**
     * 匿名函数传参数
     */
    fun noHasNameFunction() {
        fileterCountries(listOf(), fun(country, a): Boolean {
            return true
        })
    }

    /**
     * 匿名函数 Lambda 方式
     */
    fun noHasNameFunctionLambda() {
        fileterCountries(listOf(), { country, a ->
            Log.e("", "")
            true
        })
    }

    //函数类型参数
    fun fileterCountries(countrys: List<Any>, test: (country: Any, a: String) -> Boolean) {
        for (country in countrys) {
            if (test(country, "")) {

            }
        }
    }
}