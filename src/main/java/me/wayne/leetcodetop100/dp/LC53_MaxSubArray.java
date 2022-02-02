package me.wayne.leetcodetop100.dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class LC53_MaxSubArray {

    /**
     * 思考状态：dp[i]代表着以nums[i]结尾的最大的子序列和。
     * 思考状态转移方程：dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
     * 取dp[i-1] + nums[i]和 nums[i] 的最大值是因为考虑 dp[i-1] 是否对 nums[i] 产生了负增益，
     * 如果对nums[i]产生了负增益，那么不如不产生，对应的就是将dp[i-1]去掉。
     * 思考初始化：dp[0] = nums[0]，所以i必须从1开始直到末尾。
     * 思考输出：输出dp数组的最大值即可。
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
