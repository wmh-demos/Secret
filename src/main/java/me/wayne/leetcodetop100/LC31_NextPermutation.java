package me.wayne.leetcodetop100;

/**
 * 下一个排列
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * <p>
 * 思路：nums = [1,2,7,4,3,1]
 * 一、倒序遍历数组, 找出第一组: 前一个数比后一个数小的两个数, 即[2, 7]
 * 二、2所处的这个位置就是需要找出比它稍微大的数的位置
 * 三、我们从[7,4,3,1]中找出比2大的数中的最小值, 也就是3, 找到后跟2交换即可; 如果没找到的话, 直接跳到第5步
 * 四、目前nums=[1,3,7,4,2,1], 不用我说你们也看出来还不算下一个排列
 * 五、对3后面的数, 升序排列, 即最终结果: nums = [1,3,1,2,4,7]
 */
public class LC31_NextPermutation {

    public void nextPermutation(int[] nums) {
        int firstIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1) {
            // 找不到firstIndex，说明是最后一个排列，直接逆序
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int secondIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }
        swap(nums, firstIndex, secondIndex);
        reverse(nums, firstIndex + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
