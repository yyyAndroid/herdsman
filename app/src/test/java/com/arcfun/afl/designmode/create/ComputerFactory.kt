package com.arcfun.afl.designmode.create

class ComputerFactory {
    fun product(type: ComputerType): Computer {
        return when (type) {
            ComputerType.PC -> PC()
            ComputerType.Server -> Server()
        }
    }
}