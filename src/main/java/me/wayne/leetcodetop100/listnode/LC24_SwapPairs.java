package me.wayne.leetcodetop100.listnode;

import me.wayne.leetcodetop100.ListNode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * <a href="https://leetcode-cn.com/problems/swap-nodes-in-pairs/">两两交换链表中的节点</a>
 */
public class LC24_SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;

        ListNode first = head;
        ListNode second = null;
        if (first != null) {
            second = first.next;
        }

        while (first != null || second != null) {
            ListNode curFirst = first;
            ListNode curSecond = second;
            if (second != null) {
                first = second.next;
                if (first != null) {
                    second = first.next;
                }
            } else {
                first = null;
            }

            if (curSecond != null) {
                curSecond.next = null;
                index.next = curSecond;
                index = index.next;
            }
            if (curFirst != null) {
                curFirst.next = null;
                index.next = curFirst;
                index = index.next;
            }
        }

        return dummy.next;
    }
}
