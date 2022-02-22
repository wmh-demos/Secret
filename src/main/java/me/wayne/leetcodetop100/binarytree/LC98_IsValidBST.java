package me.wayne.leetcodetop100.binarytree;

import java.util.ArrayList;
import java.util.List;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * <p>
 * 思路：中序遍历实现；递归不好做，比如可能会出现右子树的叶子结点小于父节点但同时也小于根节点了。
 */
public class LC98_IsValidBST {

    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrder(inOrder, root);
        boolean res = true;
        for (int i = 1; i < inOrder.size(); i++) {
            if (inOrder.get(i - 1) >= inOrder.get(i)) {
                res = false;
                break;
            }
        }
        return res;
    }

    private void inOrder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(res, root.left);
        res.add(root.val);
        inOrder(res, root.right);
    }
}
