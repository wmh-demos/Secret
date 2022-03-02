package me.wayne.leetcodetop100.binarytree;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * 路径长度的定义：两结点之间的路径长度=它们之间的边的数量。
 * 两个叶子结点之间的路径=根结点左右孩子的深度之和。
 * <p>
 * 采用分治和递归的思想：
 * 根节点为root的二叉树的直径 = max(root->left的直径，root->right的直径，root->left的最大深度+root->right的最大深度+1)
 * <p>
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class LC543_DiameterOfBinaryTree {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left); // 左儿子为根的子树的深度
        int right = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}
