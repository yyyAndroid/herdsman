package com.arcfun.afl.tree

import java.util.*

object BinaryTree {

    /**
     * 计算有多少个节点
     */
    fun calculateHasNode(topNode: TreeNode?): Int {
        if (Objects.isNull(topNode)) return 0
        return 1 + calculateHasNode(topNode?.left) + calculateHasNode(topNode?.right)
    }

    /**
     * 翻转二叉树
     * 翻转二叉树的特点是；把每个节点下的left孩子节点和右孩子节点，进行交换
     */
    fun reverseTreeNode(topNode: TreeNode?): TreeNode? {
        if (Objects.isNull(topNode)) return null

        var tempNode = topNode?.left
        topNode?.left = topNode?.right
        topNode?.right = tempNode

        reverseTreeNode(topNode?.left)
        reverseTreeNode(topNode?.right)

        return topNode
    }

    /**
     * 填充二叉树节点右侧指针
     * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树的定义如下
     *
     * struct Node{
     *  int val
     *  Node *left
     *  Node *right
     *  Node *next
     * }
     * 填充他的每个next指针，让这个指针指向其下一个右侧节点，如果找不到下一个右侧节点，则将这个next指针设置为null
     * 初始状态下每个next都为null
     *
     * 思路是按二叉树的层来进行链接next节点， node1.left 与 node1.right链接， node1.right与node1.left进行链接
     * node2.left 与 node2.right进行链接
     */

    fun connect(topNode: TreeNode): TreeNode {
        connectNode(topNode.left, topNode.right)
        return topNode
    }

    /**
     *将两个节点的next进行链接； 一次执行该函数就是将树的一层节点进行了链接；
     * 分别为，
     * 1。 同一个树节点下的做节点和右节点进行了链接；
     * 2。 统一层级的左树的右几点，与右树的左侧节点进行链接
     * 3。 将右树下的左侧节点和右测节点进行了链接
     */
    fun connectNode(leftNode: TreeNode?, rightNode: TreeNode?) {
        if (Objects.isNull(leftNode) || Objects.isNull(rightNode)) return
        leftNode?.next = rightNode
        connectNode(leftNode?.left, leftNode?.right)
        connectNode(leftNode?.right, rightNode?.left)
        connectNode(rightNode?.left, rightNode?.right)
    }


    /**
     * 第三道题 -- 将二叉树展开为链表
     *
     */
    fun flatten(root : TreeNode?){
        if (Objects.isNull(root)) return

        flatten(root?.left)//递推
        flatten(root?.right)//递推

        var left = root?.left
        var right = root?.right

        root?.left = null
        root?.right = left

        //找到右子树的最后一个节点
        var point = root
        while (Objects.nonNull(point?.right)){
            point = point?.right
        }
        point?.right = right
    }


}