package me.wayne.leetcodetop100;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * <p>
 * 遍历数组中每个元素num。实际上我们无需一次针对每个元素num去判断num+1，num+2，num+3..
 * .是否在数组中，当num-1已经在数组中的话，那么num-1肯定会进行相应的+1遍历，然后遍历到num
 */
public class LC128_LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        // 建立一个存储所有数的set
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        // 遍历所有数字
        for (int num : set) {
            int cur = num;
            // 只有当num-1不存在时，才开始向后遍历num+1，num+2，num+3......
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            // [num, cur]之间是连续的，数字有cur - num + 1个
            ans = Math.max(ans, cur - num + 1);
        }
        return ans;
    }
}
