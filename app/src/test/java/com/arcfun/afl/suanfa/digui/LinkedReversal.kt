package com.arcfun.afl.suanfa.digui

import java.util.*

/**
 * 递归反转连标
 */
object LinkedReversal {

    /**
     * linked reversal use forEach 循环的方法
     */
    fun reverseFor(header: ListNode?): ListNode? {
        var top = header
        var header = header
        var checkNode = header?.next//目标节点

        while (Objects.nonNull(checkNode)) {
            var checkNextNode = checkNode?.next//目标的下一个阶段
            checkNode?.next = header//修改目标节点指向的节点
            header = checkNode//修改只想节点
            checkNode = checkNextNode//更新目标节点呢
        }
        top?.next = null
        return header
    }

    /**
     * linked reverse use digui 递归的方法
     * 该递归方法的定义：将header为起点的链表反转，返回反转后的头节点
     * 理解了；但是深度还是不够
     */
    fun reverseDigui(header: ListNode?): ListNode? {
        if (header?.next == null) return header
        var last = reverseDigui(header.next)
        header?.next?.next = header
        header.next = null
        return last
    }

    /**
     * assgin index reverse
     * 定义：输入头节点，从 header 到 n节点反转。返回头节点
     */
    var indexNextNode: ListNode? = null
    fun reverseN(header: ListNode?, n: Int): ListNode? {
        if (n == 1) {//最后的一个节点 为最后的头节点
            indexNextNode = header?.next
            return header
        }
        var last = reverseN(header?.next, n - 1)
        header?.next?.next = header
        header?.next = indexNextNode
        return last
    }

    /**
     * @param m 开始节点
     * @param n 结束节点
     * 定义方法的最用：将m开始， n结束 反转
     */
    fun reverseBetween(header: ListNode?, m: Int, n: Int): ListNode? {
        if (m == 1)
            return reverseN(header, n)
        var last = reverseBetween(header?.next, m - 1, n - 1)
        header?.next = last
        return header
    }

}