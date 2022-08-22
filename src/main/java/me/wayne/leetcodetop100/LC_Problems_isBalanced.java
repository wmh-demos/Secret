package me.wayne.leetcodetop100;

/**
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * https://leetcode.cn/problems/check-balance-lcci/
 */
class LC_Problems_isBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(depth(root.left), depth(root.right));
    }
}
