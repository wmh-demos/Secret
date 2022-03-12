package me.wayne.leetcodetop100;

/**
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 链接：https://leetcode-cn.com/problems/sort-colors
 */
public class LC75_SortColors {

    public void sortColors(int[] nums) {
        // 按照0、1、2的顺序排序，用双指针color和index来把数字进行交换
        int redIndex = swapColor(nums, 0, 0);
        swapColor(nums, redIndex, 1);
    }

    private int swapColor(int[] nums, int start, int color) {
        int first = start;
        int last = start;
        while (first < nums.length) {
            if (nums[first] == color) {
                swap(nums, first, last);
                last++;
            }
            first++;
        }
        return last;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
