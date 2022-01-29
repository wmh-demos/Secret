package me.wayne.leetcodetop100.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class LC103_ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();
            while (!queue.isEmpty()) {
                level.add(queue.poll());
            }

            for (TreeNode node : level) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (!leftToRight) {
                Collections.reverse(level);
            }
            leftToRight = !leftToRight;
            List<Integer> result = new ArrayList<>();
            for (TreeNode node: level) {
                result.add(node.val);
            }
            res.add(result);
        }
        return res;
    }
}
