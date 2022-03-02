package me.wayne.leetcodetop100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 */
public class LC448_FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 参考题解，利用 (x + n) % n = x的特性，将nums数组作为哈希表
        // 遍历时，找到 (nums[i] - 1) % n 下标，将该下标值加上 n
        // 最后再遍历一次，小于n的值就是没出现过的值

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int target = (nums[i] - 1) % n;
            nums[target] += n;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
