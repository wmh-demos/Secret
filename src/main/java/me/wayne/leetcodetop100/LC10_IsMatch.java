package me.wayne.leetcodetop100;

/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * <p>
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 */
public class LC10_IsMatch {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // 表示s的前i个字符与p中的前j个字符是否能够匹配
        // 数组是从下标0开始的，因此长度需要加1
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 表示s与p均为空串
        dp[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                char ch = p.charAt(j - 1);
                if (ch == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // ch不是*，可能是.或者小写字母，直接匹配
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
