package me.wayne.leetcodetop100.binarytree;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class LC110_IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.abs(leftHeight - rightHeight) <= 1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
