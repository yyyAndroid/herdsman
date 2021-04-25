package com.arcfun.afl.suanfa.digui

import java.util.*

object LinkedSourceFactory {

    fun createLinked(): ListNode {
        var header = ListNode("header", null)
        var top = header
        val lists = listOf<String>("1", "2", "3", "4", "5", "6")
        lists.forEach {
            header.next = ListNode(it, null)
            header = header.next!!
        }

        printlnList(top)

        return top
    }

    fun printlnList(listNode: ListNode?) {
        println("输出链表")
        var header = listNode
        while (Objects.nonNull(header)) {
            print(header?.ele)
            header = header?.next
        }
        println()
    }
}