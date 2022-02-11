package me.wayne.leetcodetop100.binarytree;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class LC226_InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
