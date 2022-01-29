package me.wayne.leetcodetop100.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class LC94_InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }

        traversal(root, res);
        return res;
    }

    private void traversal(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            traversal(node.left, res);
        }
        res.add(node.val);
        if (node.right != null) {
            traversal(node.right, res);
        }
    }
}
