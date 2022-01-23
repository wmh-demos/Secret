package me.wayne.leetcodetop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
 * 使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * https://leetcode-cn.com/problems/3sum
 * <p>
 * 思路：定义三个指针，k、i、j，遍历k，转化为在数组中寻找nums[k]+nums[i]+nums[j]=0的问题
 * 遍历k时有三种情况：
 * 1.nums[k]大于0，直接break，因为是升序序列，不可能存在nums[k]+nums[i]+nums[j]=0
 * 2.k>=1时，当nums[k - 1] == nums[k]时continue，避免结果重复
 * 3.使用i、j双指针逐渐逼近得到结果
 * 求出sum=nums[k] + nums[i] + nums[j]
 * sum=0，则是一组结果，左指针前进，右指针后退
 * sum小于0，左指针前进，右指针不变
 * sum大于0，左指针不变，右指针后退
 */
public class LC15_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return res;
        }

        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 1; k++) {
            if (nums[k] > 0) {
                //升序排列，nums[k]已经大于0，不可能得到nums[k]+nums[i]+nums[j]=0
                break;
            }

            if (k > 0 && nums[k - 1] == nums[k]) {
                // 遇到相同的数，直接跳过，避免得到重复的序列
                continue;
            }

            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]);//左指针前进并去重
                    while (i < j && nums[j] == nums[--j]);//右指针后退并去重
                } else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]);//左指针前进并去重
                } else {
                    while (i < j && nums[j] == nums[--j]);//右指针后退并去重
                }
            }
        }
        return res;
    }
}
