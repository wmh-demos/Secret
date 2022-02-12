package me.wayne.leetcodetop100.listnode;

import me.wayne.leetcodetop100.ListNode;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LC141_HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode oneStep = head;
        ListNode twoStep = head;
        boolean res = false;
        while (twoStep != null) {
            twoStep = twoStep.next;
            if (twoStep == null) {
                break;
            }
            twoStep = twoStep.next;

            oneStep = oneStep.next;

            if (twoStep == oneStep) {
                res = true;
                break;
            }
        }
        return res;
    }
}
