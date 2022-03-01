package me.wayne.leetcodetop100;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class LC283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        // 两个指针i、j，j从前往后遍历，碰到不等于0的整数就复制到i的位置
        // j到末尾之后，i之后的位置全是0
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }

        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
