package me.wayne.leetcodetop100.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
@SuppressWarnings("ALL")
public class LC145_PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                //利用头插法，依次插入头结点、右孩子、左孩子，得到后序遍历的顺序
                res.addFirst(root.val);
                if (root.left != null) {
                    stack.push(root.left);
                }
                root = root.right;
            } else {
                root = stack.pop();
            }
        }
        return res;
    }
}
