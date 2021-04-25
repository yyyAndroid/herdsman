package com.arcfun.afl.designmode.build

class RobotOne private constructor(
    val code: String,
    val battery: String?,
    val height: Int?,
    val weight: Int?
) {

    class Builder(val code: String) {
        private var battery: String? = null
        private var height: Int? = null
        private var weight: Int? = null

        fun setBattery(battery: String?): Builder {
            this.battery = battery
            return this
        }

        fun setHeight(height: Int?): Builder {
            this.height = height
            return this
        }

        fun setWeight(weight: Int?): Builder {
            this.weight = weight
            return this
        }

        fun build(): RobotOne {
            return RobotOne(code, battery, height, weight)
        }
    }


}