package com.arcfun.afl.designmode.build

class RobotTwo(
    val code: String,
    val battery: String? = null,
    val height: Int? = null,
    val weight: Int? = null
){
    init {
        require(weight == null ||  battery != null){
            "这里是抛出异常的信息，当weight为空的时候，battery不能为空"
        }
    }
}