package me.wayne.leetcodetop100.binarytree;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * https://leetcode-cn.com/problems/same-tree/
 */
public class LC100_IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        boolean sameVal = p.val == q.val;
        return sameVal && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
