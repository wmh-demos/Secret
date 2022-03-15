package me.wayne.leetcodetop100.listnode;

import me.wayne.leetcodetop100.ListNode;

/**
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 * <p>
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 *
 * 思路：
 * 快慢指针，求出交点，相交之后再从头结点出发，头指针和慢指针相交就是环的开始结点
 */
public class LC142_DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oneStep = head;
        ListNode twoStep = head;
        boolean ans = false;
        while (twoStep != null) {
            twoStep = twoStep.next;
            if (twoStep == null) {
                break;
            }

            twoStep = twoStep.next;
            oneStep = oneStep.next;
            if (twoStep == oneStep) {
                ans = true;
                break;
            }
        }

        if (ans) {
            while (head != null) {
                if (head == oneStep) {
                    return head;
                }
                head = head.next;
                oneStep = oneStep.next;
            }
        }

        return null;
    }
}
