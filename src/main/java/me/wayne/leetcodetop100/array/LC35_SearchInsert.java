package me.wayne.leetcodetop100.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 */
public class LC35_SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }

        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int searchResult = binarySearch(nums, 0, nums.length, target);
        if (searchResult >= 0) {
            return searchResult;
        }

        int low = 0;
        int height = 1;
        while (height < nums.length) {
            if (nums[low] < target && nums[height] > target) {
                return height;
            } else {
                low++;
                height++;
            }
        }
        return 0;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int low = start;
        int high = end - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];

            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid; // key found
            }
        }
        return -(low + 1);  // key not found.
    }
}
