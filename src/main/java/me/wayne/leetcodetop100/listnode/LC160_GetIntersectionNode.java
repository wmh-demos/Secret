package me.wayne.leetcodetop100.listnode;

import me.wayne.leetcodetop100.ListNode;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 * <p>
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class LC160_GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int step = Math.abs(lenA - lenB);
        if (lenA < lenB) {
            headB = forward(headB, step);
        } else if (lenA > lenB) {
            headA = forward(headA, step);
        }

        ListNode res = null;
        while (headA != null && headB != null) {
            if (headA == headB) {
                res = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return res;
    }

    private ListNode forward(ListNode head, int step) {
        for (int i = 0; i < step; i++) {
            head = head.next;
        }
        return head;
    }

    private int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int result = 0;
        while (head != null) {
            result++;
            head = head.next;
        }
        return result;
    }
}
