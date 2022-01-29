package me.wayne.leetcodetop100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * https://leetcode-cn.com/problems/permutations/
 */
public class LC46_Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        // 通过回溯法得到结果，path用于保存单次遍历的结果
        // 当path的长度等于nums的长度时，得到一个结果，拷贝至res中
        List<Integer> path = new ArrayList<>();
        // 用于保存当前这次生成结果中是否已经包含了某个位置的值的数组
        boolean[] visited = new boolean[nums.length];
        dfs(path, res, nums, visited);
        return res;
    }

    private void dfs(List<Integer> path, List<List<Integer>> res, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                // 当前这次生成结果里已经有了nums[i]这个位置的数字，跳过
                continue;
            }

            visited[i] = true;
            path.add(nums[i]);
            dfs(path, res, nums, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
