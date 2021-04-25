package com.arcfun.afl.suanfa

import com.arcfun.afl.suanfa.digui.LinkedReversal
import com.arcfun.afl.suanfa.digui.LinkedSourceFactory
import com.arcfun.afl.suanfa.digui.ListNode
import com.arcfun.afl.suanfa.kline.KLine
import org.junit.Test

class SuanfaTest {
    @Test
    fun SuanfaMain() {
       var header = LinkedSourceFactory.createLinked()
//        LinkedSourceFactory.printlnList(LinkedReversal.reverseDigui(header))
//        LinkedSourceFactory.printlnList(LinkedReversal.reverseN(header, 2))
//        LinkedSourceFactory.printlnList(LinkedReversal.reverseBetween(header, 2, 5))
        LinkedSourceFactory.printlnList(KLine.reverseK(header, 2))
    }
}
