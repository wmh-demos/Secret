package me.wayne.leetcodetop100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * https://leetcode-cn.com/problems/combinations/
 * <p>
 * 思路：
 * 使用回溯算法解决问题
 */
public class LC77_Combine {

    public List<List<Integer>> combine(int n, int k) {
        //保存结果的List
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }

        // 从 1 开始是题目的设定
        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int startIndex, List<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索起点
        for (int i = startIndex; i <= n; i++) {
            // 向路径变量里添加一个数
            path.add(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, res);
            // 深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.remove(path.size() - 1);
        }
    }
}
