package me.wayne.leetcodetop100.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 */
public class LC236_LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = null;

        List<TreeNode> bfsNodes = getBfsNode(root);
        Collections.reverse(bfsNodes);
        for (TreeNode node : bfsNodes) {
            if (isAncestor(node, p, q)) {
                res = node;
                break;
            }
        }
        return res;
    }

    private boolean isAncestor(TreeNode ancestor, TreeNode p, TreeNode q) {
        if (ancestor == null || p == null || q == null) {
            return false;
        }

        List<TreeNode> bfsNodes = getBfsNode(ancestor);
        int count = 0;
        for (TreeNode node : bfsNodes) {
            if (node == p || node == q) {
                count++;
            }
        }
        return count == 2;
    }

    private List<TreeNode> getBfsNode(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<TreeNode> res = new ArrayList<>();
        List<TreeNode> tmpList = new ArrayList<>();
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                tmpList.add(node);
            }

            for (TreeNode node : tmpList) {
                res.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            tmpList.clear();
        }
        return res;
    }
}
