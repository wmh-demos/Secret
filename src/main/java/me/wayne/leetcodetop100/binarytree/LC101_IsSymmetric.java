package me.wayne.leetcodetop100.binarytree;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class LC101_IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && check(node1.left, node2.right) && check(node1.right,
                node2.left);
    }
}
