package me.wayne.leetcodetop100.subarray;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 *
 * <a href="https://leetcode.cn/problems/subarray-sum-equals-k/?envType=study-plan-v2&envId=top-100-liked">和为 K 的子数组</a>
 */
public class LC560_SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int count = 0; //统计
        int sum = 0;   //前缀和
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            sum += num;
            if (sum == k) { //从下标 0 累加到 i 刚好等于 k
                count++;
            }
            if (hashMap.containsKey(sum - k)) {
                count += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
