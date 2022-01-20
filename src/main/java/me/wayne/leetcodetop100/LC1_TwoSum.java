package me.wayne.leetcodetop100;

import java.util.HashMap;
import java.util.Map;


/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * https://leetcode-cn.com/problems/two-sum
 */
@SuppressWarnings("UnnecessaryLocalVariable")
public class LC1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int plus1 = nums[i];
            int index1 = i;

            int plus2 = target - plus1;
            Integer index2 = map.get(plus2);
            if (index2 != null) {
                result[0] = index1;
                result[1] = index2;
                return result;
            } else {
                map.put(plus1, index1);
            }
        }
        return result;
    }
}
