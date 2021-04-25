package com.arcfun.afl.suanfa.kline

import com.arcfun.afl.suanfa.digui.ListNode
import java.util.*


object KLine {
    /**
     * linked reverse k
     */
    fun kline(header: ListNode, k: Int) {

    }

    /**
     * reverse linked list
     */
    fun reverse(head: ListNode?): ListNode? {
        var current = head

        var pre: ListNode? = null

        while (Objects.nonNull(current)) {

            var nextNode = current?.next//记录下一个节点

            current?.next = pre//当前节点指向前节点

            pre = current//前驱节点向下移动

            current = nextNode//当前节点向下移动
        }

        return pre
    }

    /**
     * 返回新的头节点
     */
    fun reverseEnd(header: ListNode?, end: ListNode?): ListNode? {
        var current = header
        var pre: ListNode? = null
        var next: ListNode? = null
        while (current != end) {
            next = current?.next
            current?.next = pre
            pre = current
            current = next
        }
        return pre
    }

    /**
     * 反转第K
     */
    fun reverseK(header: ListNode?, k: Int): ListNode? {
        if (Objects.isNull(header)) return header
        var kPre = header
        var top = header
        for (index in 0 until k) {
            if (kPre == null) return header
            kPre = kPre?.next
        }

        var newHeader = reverseEnd(header, kPre)

        top?.next = reverseK(kPre, k)

        return newHeader
    }

}