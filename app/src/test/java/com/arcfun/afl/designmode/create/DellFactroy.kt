package com.arcfun.afl.designmode.create

class DellFactroy : AbstructFactory() {
    override fun product(): Computer = Dell()
}