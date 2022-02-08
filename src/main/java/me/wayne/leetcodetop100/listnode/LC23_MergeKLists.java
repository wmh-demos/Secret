package me.wayne.leetcodetop100.listnode;

import me.wayne.leetcodetop100.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 采用顺序合并的思路
 * 有更优的分治的合并的思路，参考题解
 * <p>
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class LC23_MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        for (ListNode node : lists) {
            if (node == null) {
                //为空直接跳过
                continue;
            }

            // 遍历已dummy为头结点的链表，将node链表插入
            if (dummy.next == null) {
                //dummy的next为空，直接拼接
                dummy.next = node;
            } else {
                dummy.next = mergeListNode(dummy.next, node);
            }
        }

        return dummy.next;
    }

    @SuppressWarnings("ConstantConditions")
    private ListNode mergeListNode(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (first != null || second != null) {
            if (first == null) {
                current.next = new ListNode(second.val);
                current = current.next;
                second = second.next;
            } else if (second == null) {
                current.next = new ListNode(first.val);
                current = current.next;
                first = first.next;
            } else {
                if (first.val <= second.val) {
                    current.next = new ListNode(first.val);
                    current = current.next;
                    first = first.next;
                } else {
                    current.next = new ListNode(second.val);
                    current = current.next;
                    second = second.next;
                }
            }
        }
        return dummy.next;
    }
}
