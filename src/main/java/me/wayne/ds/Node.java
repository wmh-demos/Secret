package me.wayne.ds;

public class Node {

    public Node next;
    public int value;

    public Node(int value) {
        this.value = value;
    }

    public static void testReverse() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Node reverse = Node.reverse(head);
        while (reverse != null) {
            System.out.println(reverse.value);
            reverse = reverse.next;
        }
    }

    public static Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        return reverseInner(null, node);
    }

    private static Node reverseInner(Node p, Node q) {
        if (q == null) {
            return p;
        }

        Node temp = q.next;
        q.next = p;

        return reverseInner(q, temp);
    }
}
