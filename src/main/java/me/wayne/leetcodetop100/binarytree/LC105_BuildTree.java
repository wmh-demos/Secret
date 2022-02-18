package me.wayne.leetcodetop100.binarytree;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class LC105_BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }

        int[] leftInorder = new int[rootIndex];
        System.arraycopy(inorder, 0, leftInorder, 0, leftInorder.length);
        int[] rightInorder = new int[inorder.length - leftInorder.length - 1];
        System.arraycopy(inorder, leftInorder.length + 1, rightInorder, 0, rightInorder.length);

        int[] leftPreorder = new int[leftInorder.length];
        System.arraycopy(preorder, 1, leftPreorder, 0, leftPreorder.length);
        int[] rightPreorder = new int[rightInorder.length];
        System.arraycopy(preorder, leftInorder.length + 1, rightPreorder, 0, rightPreorder.length);

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
