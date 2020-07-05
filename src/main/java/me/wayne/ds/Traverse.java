package me.wayne.ds;

import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

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

    static void dfsMultiTreeNode(MultiTreeNode root) {
        if (root == null) {
            return;
        }

        Stack<MultiTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            MultiTreeNode node = stack.pop();
            System.out.println(node.value() + "\t");

            List<MultiTreeNode> children = node.getChildren();
            if (children != null && !children.isEmpty()) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
    }

    static void bfdMultiTreeNode(MultiTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<MultiTreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            MultiTreeNode first = queue.poll();
            System.out.println(first.value() + "\t");

            List<MultiTreeNode> children = first.getChildren();
            if (children != null && children.size() > 0) {
                queue.addAll(children);
            }
        }
    }
}
