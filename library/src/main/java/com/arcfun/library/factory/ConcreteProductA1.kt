package com.arcfun.library.factory

import android.accounts.AbstractAccountAuthenticator

/**
 * 具体的产品类A1
 */
class ConcreteProductA1 : AbstractProductA() {
    override fun method() {
        System.out.println("具体产品A1的方法")
    }
}