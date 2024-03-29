package me.wayne.leetcodetop100.dp;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * <p>
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
class LC300_LengthOfLIS {

    /**
     * Longest Increasing Subsequence
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //dp[i]的含义是以 num[i] 为结尾的最长递增子序列
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            //j >= 0 且 < i，每轮计算dp[i]时，遍历[0, i}
            //当nums[i]>nums[j]时，满足条件，LIS为dp[j] + 1
            //当nums[i]<=nums[j]时，不满足条件，跳过
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = 0;
        for (int value : dp) {
            max = Math.max(max, value);
        }
        return max;
    }
}