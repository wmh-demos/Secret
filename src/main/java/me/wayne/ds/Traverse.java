package wayne.ds;

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

    public static void inOrder(BitTree tree) {
        if (tree == null) return;

        if (tree.left != null) {
            inOrder(tree.left);
        }
        System.out.printf(tree.value + " ");
        if (tree.right != null) {
            inOrder(tree.right);
        }
    }

    public static void postOrder(BitTree tree) {
        if (tree == null) return;

        if (tree.left != null) {
            postOrder(tree.left);
        }
        if (tree.right != null) {
            postOrder(tree.right);
        }
        System.out.printf(tree.value + " ");
    }

    public static void nonRecursionPreOrder(BitTree tree) {
        Stack<BitTree> stack = new Stack<BitTree>();
        while (!stack.isEmpty() || tree != null) {
            if (tree != null) {
                System.out.printf(tree.value + " ");
                stack.push(tree);
                tree = tree.left;
            } else {
                tree = stack.pop();
                tree = tree.right;
            }
        }
    }

    public static void nonRecursionInOrder(BitTree tree) {
        Stack<BitTree> stack = new Stack<BitTree>();
        while (!stack.isEmpty() || tree != null) {
            if (tree != null) {
                stack.push(tree);
                tree = tree.left;
            } else {
                tree = stack.pop();
                System.out.printf(tree.value + " ");
                tree = tree.right;
            }
        }
    }
}
