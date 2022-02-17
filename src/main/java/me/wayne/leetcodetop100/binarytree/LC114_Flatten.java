package me.wayne.leetcodetop100.binarytree;

import java.util.ArrayList;
import java.util.List;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 */
public class LC114_Flatten {

    public void flatten(TreeNode root) {
        List<TreeNode> list = traversal(root);
        for (int i = 0; i < list.size(); i++) {
            TreeNode cur = list.get(i);
            TreeNode next = null;
            if (i + 1 < list.size()) {
                next = list.get(i + 1);
            }
            cur.left = null;
            cur.right = next;
        }
    }

    private List<TreeNode> traversal(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preTraversal(list, root);
        return list;
    }

    private void preTraversal(List<TreeNode> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        if (root.left != null) {
            preTraversal(list, root.left);
        }
        if (root.right != null) {
            preTraversal(list, root.right);
        }
    }
}
