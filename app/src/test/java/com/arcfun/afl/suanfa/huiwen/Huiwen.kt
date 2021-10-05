package com.arcfun.afl.suanfa.huiwen

import com.arcfun.afl.suanfa.digui.ListNode
import java.util.*

object Huiwen {

    var left : ListNode? = null

    fun isPalindrome(head : ListNode) : Boolean{
        left = head
        return traverseNode(head)
    }

    fun traverseNode(right : ListNode?) : Boolean{
        if (right == null) return true
        //进行压栈
        var res = traverseNode(right.next)
        //后续遍历代码
        res = res && (right.ele == left?.ele)

        left = left?.next
        return res
    }


    fun traverse(head : ListNode?) : ListNode?{
        var current = head
        var pre : ListNode?= null
        var next = head
        while (Objects.nonNull(current)){
            next = current?.next
            current?.next = pre
            pre = current
            current = next
        }
        return pre
    }

}