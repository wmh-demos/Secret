package me.wayne.leetcodetop100.binarytree;

import me.wayne.leetcodetop100.TreeNode;

/**
 *
 */
public class LC104_MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
