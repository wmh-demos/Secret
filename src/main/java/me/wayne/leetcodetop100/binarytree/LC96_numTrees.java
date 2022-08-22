package me.wayne.leetcodetop100.binarytree;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * https://leetcode.cn/problems/unique-binary-search-trees/
 */
class LC96_numTrees {

    public int numTrees(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i] += arr[j - 1] * arr[i - j];
            }
        }
        return arr[n];
    }
}
