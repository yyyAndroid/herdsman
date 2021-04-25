package com.arcfun.library.factory.absfactory

import com.arcfun.library.factory.AbstractProductA
import com.arcfun.library.factory.AbstractProductB

abstract class AbstractFactory {

    /**
     * 创建产品A类的方法
     */
     abstract fun createProductA(): AbstractProductA


    /**
     * 创建产品B类的方法
     */
    abstract fun createProductB() : AbstractProductB
}