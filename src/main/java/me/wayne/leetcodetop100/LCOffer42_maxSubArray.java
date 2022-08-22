package me.wayne.leetcodetop100;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 *
 * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
class LCOffer42_maxSubArray {

   public int maxSubArray(int[] nums) {
      int max = nums[0];
      for (int i = 1; i < nums.length; i++) {
         nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
         if (nums[i] > max) {
            max = nums[i];
         }
      }
      return max;
   }
}
