package me.wayne.ds;

import java.util.Stack;

class Traverse {

    static void preOrder(BitTree tree) {
        if (tree == null) return;

        System.out.print(tree.value + " ");

        if (tree.left != null) {
            preOrder(tree.left);
        }
        if (tree.right != null) {
            preOrder(tree.right);
        }
    }

    static void inOrder(BitTree tree) {
        if (tree == null) return;

        if (tree.left != null) {
            inOrder(tree.left);
        }
        System.out.print(tree.value + " ");
        if (tree.right != null) {
            inOrder(tree.right);
        }
    }

    static void postOrder(BitTree tree) {
        if (tree == null) return;

        if (tree.left != null) {
            postOrder(tree.left);
        }
        if (tree.right != null) {
            postOrder(tree.right);
        }
        System.out.print(tree.value + " ");
    }

    static void nonRecursionPreOrder(BitTree tree) {
        Stack<BitTree> stack = new Stack<>();
        while (!stack.isEmpty() || tree != null) {
            if (tree != null) {
                System.out.print(tree.value + " ");
                stack.push(tree);
                tree = tree.left;
            } else {
                tree = stack.pop();
                tree = tree.right;
            }
        }
    }

    static void nonRecursionInOrder(BitTree tree) {
        Stack<BitTree> stack = new Stack<>();
        while (!stack.isEmpty() || tree != null) {
            if (tree != null) {
                stack.push(tree);
                tree = tree.left;
            } else {
                tree = stack.pop();
                System.out.print(tree.value + " ");
                tree = tree.right;
            }
        }
    }
}
