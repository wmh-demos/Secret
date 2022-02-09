package me.wayne.leetcodetop100.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LC107_LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> nodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                nodes.add(node);
            }

            List<Integer> result = new ArrayList<>();
            for (TreeNode node: nodes) {
                result.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(0, result);
        }
        return res;
    }
}
