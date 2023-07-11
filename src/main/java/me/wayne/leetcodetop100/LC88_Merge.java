package me.wayne.leetcodetop100;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * <a href="https://leetcode.cn/problems/merge-sorted-array/">合并两个有序数组</a>
 * <p>
 * 思路：从后往前拷贝，避免需要复制出一个nums1对象
 */
public class LC88_Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }

        m--;
        n--;
        int index = nums1.length - 1;
        for (int i = 0; i < nums1.length; i++) {
            if (m < 0) {
                int value = nums2[n--];
                nums1[index--] = value;
            } else if (n < 0) {
                int value = nums1[m--];
                nums1[index--] = value;
            } else {
                int value;
                if (nums1[m] >= nums2[n]) {
                    value = nums1[m--];
                } else {
                    value = nums2[n--];
                }
                nums1[index--] = value;
            }
        }
    }
}
