package me.wayne.leetcodetop100.twopointers;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * <p>
 * 思路：双指针法
 * 考虑用 2 个指针，一个在前记作 p，一个在后记作 q，算法流程如下：
 * 比较 p 和 q 位置的元素是否相等
 * 如果相等，q 后移 1 位
 * 如果不相等，将 q 位置的元素复制到 p+1 位置上，p 后移一位，q 后移 1 位
 * 重复上述过程，直到 q 等于数组长度。
 */
public class LC26_RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int pre = 0;
        int after = 1;
        while (after < nums.length) {
            if (nums[after] == nums[pre]) {
                after++;
            } else {
                nums[pre + 1] = nums[after];
                pre++;
                after++;
            }
        }
        return pre + 1;
    }
}
