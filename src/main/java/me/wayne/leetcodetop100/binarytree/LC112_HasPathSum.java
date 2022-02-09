package me.wayne.leetcodetop100.binarytree;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给你二叉树的根节点root和一个表示目标和的整数targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/path-sum
 */
public class LC112_HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        } else {
            boolean leftHasPath = false;
            if (root.left != null) {
                leftHasPath = hasPathSum(root.left, targetSum - root.val);
            }
            boolean rightHasPath = false;
            if (root.right != null) {
                rightHasPath = hasPathSum(root.right, targetSum - root.val);
            }
            return leftHasPath || rightHasPath;
        }
    }
}
