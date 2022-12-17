package me.wayne

import me.wayne.file.readFileAndReadAsLine
import me.wayne.leetcodetop100.ListNode

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello IntelliJ!!!")

        calculateTotal()

        testPrintListNode()
    }

    private fun calculateTotal() {
        var total = 0F
        val lines = readFileAndReadAsLine("money.txt")
        lines.forEach {
            val index = it.indexOf("￥")
            if (index >= 0 && index < it.length - 1) {
                total += it.substring(index + 1).toFloat()
            }
        }
        println("total: $total")
    }

    private fun testPrintListNode() {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        printListNode(node1)
    }

    private fun printListNode(node: ListNode) {
        var head = node
        print("${head.`val`}")
        while (head.next != null) {
            print("->")
            print(head.next.`val`)
            head = head.next
        }
    }
}