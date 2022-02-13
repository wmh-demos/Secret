package me.wayne.leetcodetop100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * <p>
 * wordDict 中的所有字符串 互不相同
 * <p>
 * 链接：https://leetcode-cn.com/problems/word-break
 */
public class LC139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        // dp[i]dp[i] 表示 ss 的前 ii 位是否可以用 wordDict 中的单词表示
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) {
                continue;
            }

            for (String word: set) {
                // 遍历s中的每个字符，然后看 wordDict 中有没有单词能够匹配上从i到s.length区间单词
                int end = i + word.length();
                if (end <= s.length() && s.substring(i, end).equals(word)) {
                    dp[end] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
