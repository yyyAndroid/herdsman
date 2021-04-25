package com.arcfun.afl.utils


inline fun List<Any>.sureNull(): Boolean {
    return null == this && this.isEmpty()
}