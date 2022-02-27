package me.wayne.leetcodetop100.listnode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import me.wayne.leetcodetop100.ListNode;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class LC234_IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        // 求出中间结点
        ListNode half = getHalfNode(head);
        // 将中间开始的后半部放到List当中，再反转
        List<ListNode> halfList = new LinkedList<>();
        while (half != null) {
            halfList.add(half);
            half = half.next;
        }
        Collections.reverse(halfList);

        boolean res = true;
        for (ListNode node : halfList) {
            if (node.val != head.val) {
                res = false;
                break;
            }
            head = head.next;
        }

        return res;
    }

    private ListNode getHalfNode(ListNode head) {
        if (head == null) {
            return null;
        }

        int count = 0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            count++;
            fast = fast.next;
            if (fast != null) {
                count++;
                fast = fast.next;
                slow = slow.next;
            }
        }
        // 链表长度是奇数个，则再往后一位
        if (count % 2 != 0) {
            slow = slow.next;
        }
        return slow;
    }
}
