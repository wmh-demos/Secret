package me.wayne.leetcodetop100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * https://leetcode-cn.com/problems/generate-parentheses/
 * <p>
 * 思路：使用回溯法，左括号数 > n，右括号 > 左括号时结束递归
 * https://leetcode-cn.com/problems/generate-parentheses/solution/sui-ran-bu-shi-zui-xiu-de-dan-zhi-shao-n-0yt3/
 */
public class LC22_GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, n);
        return res;
    }

    private void dfs(List<String> res, String paths, int left, int right, int n) {
        if (left > n) {
            // 左括号数量超了
            return;
        }
        if (right > n) {
            // 右括号数量超了
            return;
        }
        if (right > left) {
            // 右括号比左括号多了
            return;
        }
        if (paths.length() == n * 2) {
            // paths的长度是n*2时得到结果
            res.add(paths);
            return;
        }
        dfs(res, paths + "(", left + 1, right, n);
        dfs(res, paths + ")", left, right + 1, n);
    }
}
