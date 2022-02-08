package me.wayne.leetcodetop100;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-element
 */
public class LC27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int num : nums) {
            if (num != val) {
                nums[result++] = num;
            }
        }

        return result;
    }
}
