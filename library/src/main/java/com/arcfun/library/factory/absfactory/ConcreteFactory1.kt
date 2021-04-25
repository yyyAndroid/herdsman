package com.arcfun.library.factory.absfactory

import com.arcfun.library.factory.AbstractProductA
import com.arcfun.library.factory.AbstractProductB
import com.arcfun.library.factory.ConcreteProductA1
import com.arcfun.library.factory.ConcreteProductB1

/**
 * 具体工厂类 1
 */
class ConcreteFactory1 : AbstractFactory() {
    override fun createProductA(): AbstractProductA {
        return ConcreteProductA1()
    }

    override fun createProductB(): AbstractProductB {
        return ConcreteProductB1()
    }
}