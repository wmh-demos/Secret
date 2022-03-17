package me.wayne.leetcodetop100.listnode;

import me.wayne.leetcodetop100.ListNode;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * https://leetcode-cn.com/problems/sort-list/
 */
public class LC148_SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode half = getHalf(head);
        ListNode anotherHalf = half.next;
        half.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(anotherHalf);

        return mergeList(left, right);
    }

    private ListNode getHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = new ListNode(-1);
        pre.next = slow;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }

            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        return pre;
    }

    private ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (head1 != null || head2 != null) {
            if (head1 == null || head2 == null) {
                if (head1 == null) {
                    dummy.next = head2;
                    head2 = head2.next;
                } else {
                    dummy.next = head1;
                    head1 = head1.next;
                }
            } else {
                if (head1.val <= head2.val) {
                    dummy.next = head1;
                    head1 = head1.next;
                } else {
                    dummy.next = head2;
                    head2 = head2.next;
                }
            }
            dummy = dummy.next;
        }
        return head.next;
    }
}
