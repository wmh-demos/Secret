package me.wayne.leetcodetop100;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 * <p>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
@SuppressWarnings("ALL")
public class LC21_MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                result.next = l2;
                result = result.next;
                l2 = l2.next;
                continue;
            }

            if (l2 == null) {
                result.next = l1;
                result = result.next;
                l1 = l1.next;
                continue;
            }

            if (l1.val < l2.val) {
                result.next = l1;
                result = result.next;
                l1 = l1.next;
            } else {
                result.next = l2;
                result = result.next;
                l2 = l2.next;
            }
        }

        return head.next;
    }
}
