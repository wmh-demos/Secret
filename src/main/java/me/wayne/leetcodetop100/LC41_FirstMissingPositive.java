package me.wayne.leetcodetop100;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class LC41_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        // 思路：遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，
        // 然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加1。
        for (int i = 0; i < nums.length; i++) {
            // 判断交换的条件，当前下标的值nums[i]在[1, len]之间，并且值不正确nums[i] != i + 1
            // nums[i] != nums[nums[i] - 1] 是判断没有重复的值，否则无法结束循环
            // 使用while就是为了在nums[i]这个位置，要么得到正确的值，要么得到负数、0，只要是[1, len]之间的数，就一直换
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != i + 1 && nums[i] != nums[
                    nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
