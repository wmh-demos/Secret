package me.wayne.leetcodetop100;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */
public class LC215_FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeapFix(nums, i, nums.length - 1);
        }
        for (int i = nums.length - 1; i > nums.length - k - 1; i--) {
            swap(nums, 0, i);
            maxHeapFix(nums, 0, i - 1);
        }
        return nums[nums.length - k];
    }

    private void maxHeapFix(int[] nums, int start, int end) {
        for (int son = start * 2 + 1; son <= end; start = son, son = son * 2 + 1) {
            if (son + 1 <= end && nums[son + 1] > nums[son]) {
                son++;
            }
            if (nums[son] > nums[start]) {
                swap(nums, start, son);
            }
        }
    }

    private void swap(int[] nums, int one, int other) {
        int temp = nums[other];
        nums[other] = nums[one];
        nums[one] = temp;
    }
}
