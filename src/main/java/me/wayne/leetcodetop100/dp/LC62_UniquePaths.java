package me.wayne.leetcodetop100.dp;

/**
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 思路：
 * 1.动态规划
 * <p>
 * 2.组合知识，一共需要走m+n-2步，需要在里头挑出m-1步向下，n-1步向右
 */
public class LC62_UniquePaths {

    public int uniquePaths(int m, int n) {
        // 组合公式=[m + n - 2, n] / [m - 1, 1]
        long ans = 1;
        // 用x来对应n，y来对应m
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
