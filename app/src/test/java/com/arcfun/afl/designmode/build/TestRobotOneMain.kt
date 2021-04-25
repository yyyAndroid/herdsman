package com.arcfun.afl.designmode.build

import org.junit.Test


/**
 * 利用具名可选参数替代 build模式
 */
class TestRobotOneMain {

    @Test
    fun test() {
        var robotOne = RobotOne.Builder("007")
            .setBattery("R6")
            .setHeight(100)
            .setWeight(80)
            .build()

        val robot = RobotTwo(code = "001", battery = "R6")
        val robot2 = RobotTwo(code = "002")
    }
}