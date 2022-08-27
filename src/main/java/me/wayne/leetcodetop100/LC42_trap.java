package me.wayne.leetcodetop100;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 来源：力扣（LeetCode）
 * <a href="https://leetcode.cn/problems/trapping-rain-water">链接</a>
 */
public class LC42_trap {

    /**
     * 思路1：求出每一列可以储存的水，最后求和。分别求出当前列左边、右边最高墙max1、max2，求出min=Math.min(max1, max2)。
     * 只有min大于当前列的高度才能储水，min小于等于时，水都是0。时间复杂度n的平方。
     */
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int value = height[i];
            int max1 = getMax(height, 0, i);
            int max2 = getMax(height, i + 1, height.length);
            int min = Math.min(max1, max2);
            if (min > value) {
                sum += min - value;
            }
        }
        return sum;
    }

    private int getMax(int[] arr, int left, int right) {
        int max = arr[left];
        for (int i = left; i < right; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
