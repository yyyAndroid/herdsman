package com.arcfun.library.factory.absfactory

import com.arcfun.library.factory.*

/**
 * 具体工厂类 2
 */
class ConcreateFactroy2 : AbstractFactory() {
    override fun createProductA(): AbstractProductA {
        return ConcreteProjectA2()
    }

    override fun createProductB(): AbstractProductB {
        return ConcreteProductB2()
    }
}