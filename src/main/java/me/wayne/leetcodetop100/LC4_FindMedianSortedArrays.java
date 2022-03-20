package me.wayne.leetcodetop100;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
public class LC4_FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int[] num = new int[nums1.length + nums2.length];
        while (index1 < nums1.length || index2 < nums2.length) {
            if (index1 >= nums1.length) {
                num[index] = nums2[index2];
                index2++;
            } else if (index2 >= nums2.length) {
                num[index] = nums1[index1];
                index1++;
            } else {
                if (nums1[index1] <= nums2[index2]) {
                    num[index] = nums1[index1];
                    index1++;
                } else {
                    num[index] = nums2[index2];
                    index2++;
                }
            }

            index++;
        }

        if (num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }

        int half = num.length / 2;
        if (num.length % 2 == 0) {
            return ((double) (num[half]) + (double) (num[half - 1])) / 2;
        } else {
            return num[half];
        }
    }
}
