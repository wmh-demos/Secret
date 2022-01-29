package me.wayne.leetcodetop100.binarytree;

import java.util.Arrays;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 */
public class LC108_SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        } else if (nums.length == 2) {
            TreeNode root = new TreeNode(nums[1]);
            root.left = new TreeNode(nums[0]);
            return root;
        } else {
            int mid = nums.length / 2;
            TreeNode root = new TreeNode(nums[mid]);

            int[] leftArr =  Arrays.copyOfRange(nums, 0, mid);
            int[] rightArr = Arrays.copyOfRange(nums, mid + 1, nums.length);
            TreeNode left = sortedArrayToBST(leftArr);
            TreeNode right = sortedArrayToBST(rightArr);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
