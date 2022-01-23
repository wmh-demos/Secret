package me.wayne.leetcodetop100;

/**
 * 删除链表的倒数第 N 个结点
 * <p>
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class LC19_RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        //使用快慢指针的解法，
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        int i = 0;
        while (i < n) {
            i++;
            if (fast != null) {
                fast = fast.next;
            }
        }

        if (fast == null) {
            return head;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
