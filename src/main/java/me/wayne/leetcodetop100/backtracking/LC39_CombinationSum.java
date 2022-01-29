package me.wayne.leetcodetop100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，
 * 找出candidates中可以使数字和为目标数target 的 所有不同组合，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。
 * 如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class LC39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        dfs(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int index, int target) {
        int result = 0;
        for (Integer value : path) {
            result = result + value;
        }
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index ; i < candidates.length; i++) {
            int value = candidates[i];
            if (value > target) {
                continue;
            }

            path.add(value);
            dfs(res, path, candidates, i, target - value);
            path.remove(path.size() - 1);
        }
    }
}
