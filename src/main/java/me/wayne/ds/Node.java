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
        Node.reverseHalf(head);
        printNode(head);
    }

    public static Node reverseRecursive(Node node) {
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

    private static Node reverseNonRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;

            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static void reverseHalf(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        //构造一个临时结点
        Node pre = new Node(0);
        pre.next = head;

        Node half = head;
        Node tail = head;
        while (tail.next != null) {
            //快慢指针，tail走两步，half走一步
            tail = tail.next;
            half = half.next;
            pre = pre.next;

            if (tail.next != null) {
                tail = tail.next;
            }
        }

        pre.next = null;
        reverseNonRecursive(half);
        pre.next = tail;
    }

    private static void printNode(Node node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
