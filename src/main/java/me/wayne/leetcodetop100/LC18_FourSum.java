package me.wayne.leetcodetop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组
 * [nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n , a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/4sum
 */
public class LC18_FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), nums, 0, target);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, int[] nums, int index,
            int target) {
        if (nums.length - index + path.size() < 4) {
            return;
        }
        if (path.size() == 4) {
            if (target == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int value = nums[i];
            if (index != i && nums[i - 1] == nums[i]) {
                continue;
            }

            int newIndex = i + 1;
            int newTarget = target - value;
            path.add(value);
            dfs(ans, path, nums, newIndex, newTarget);
            path.remove(path.size() - 1);
        }
    }
}
