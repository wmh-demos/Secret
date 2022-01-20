package me.wayne.leetcodetop100;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * https://leetcode-cn.com/problems/add-two-numbers
 *
 * 每次相加得到一个值
 * 1.将sum%10赋给新结点
 * 2.将sum/10赋给carry
 * 3.最后两个结点相加大于10的话，carry为1，还要再拼接一个值为1的结点
 */
public class LC2_AddTwoNumbers {

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //用来记录两个结点想加是否大于10，如果大于10，则carry=1
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        while(l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;

            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            cursor.next = node;
            cursor = node;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            cursor.next = new ListNode(1);
        }

        return head.next;
    }
}
