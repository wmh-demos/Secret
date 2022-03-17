package me.wayne.leetcodetop100;

/**
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 */
public class LC152_MaxProduct {

    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int preMax = nums[0];
        int preMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // 由于有负数，每个位置的最大值可能是当前值num乘以前一位的最大值，也可能是num乘以前一位最小值
            int curMax = Math.max(num, Math.max(preMax * num, preMin * num));
            int curMin = Math.min(num, Math.min(preMax * num, preMin * num));
            ans = Math.max(curMax, ans);
            preMax = curMax;
            preMin = curMin;
        }
        return ans;
    }
}
