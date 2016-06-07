package me.wayne.ds;

import java.util.Stack;

public class Traverse {

    public static void preOrder(BitTree tree) {
        if (tree == null) return;

        System.out.printf(tree.value + " ");

        if (tree.left != null) {
            preOrder(tree.left);
        }
        if (tree.right != null) {
            preOrder(tree.right);
        }
    }

    public static void nonRecursionPreOrder(BitTree tree) {
        if (tree == null) return;

        Stack<BitTree> stack = new Stack<BitTree>();
        BitTree t = tree;
        stack.push(t);
        System.out.println();

        while (!stack.isEmpty()) {
            if (t != null) {
                System.out.printf(t.value + " ");
                stack.push(t);
                t = t.left;
            } else {
                t = stack.pop();
                t = t.right;
            }
        }
    }
}
