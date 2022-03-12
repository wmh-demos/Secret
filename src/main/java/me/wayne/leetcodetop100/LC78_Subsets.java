package me.wayne.leetcodetop100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * https://leetcode-cn.com/problems/subsets/
 * 思路：
 * 1.用二进制位来表示每个数是否在自己中
 * 2.回溯法
 */
public class LC78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            list.clear();
            for (int j = 0; j < nums.length; j++) {
                // 根据i的值，每次遍历nums中的[0, len - 1]
                // 判断i的值中j这一位是否是1，如果是1就放到list中
                if (((1 << j) & i ) != 0) {
                    list.add(nums[j]);
                }
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}
