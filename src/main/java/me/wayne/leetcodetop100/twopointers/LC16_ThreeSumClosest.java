package me.wayne.leetcodetop100.twopointers;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * <p>
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 */
public class LC16_ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0 ; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start != end) {
                int value = nums[i] + nums[start] + nums[end];
                int minus = target - value;

                if (Math.abs(minus) < min) {
                    min = Math.abs(minus);
                    ans = value;
                }

                if (minus > 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return ans;
    }
}
