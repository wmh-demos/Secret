package me.wayne.leetcodetop100;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode node) {
        val = x;
        this.next = node;
    }
}