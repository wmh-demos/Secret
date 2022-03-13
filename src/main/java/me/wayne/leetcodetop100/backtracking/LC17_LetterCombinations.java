package me.wayne.leetcodetop100.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LC17_LetterCombinations {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }

        Map<Character, String> digitToLetterMap = new HashMap<>();
        digitToLetterMap.put('2', "abc");
        digitToLetterMap.put('3', "def");
        digitToLetterMap.put('4', "ghi");
        digitToLetterMap.put('5', "jkl");
        digitToLetterMap.put('6', "mno");
        digitToLetterMap.put('7', "pqrs");
        digitToLetterMap.put('8', "tuv");
        digitToLetterMap.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        dfs(digitToLetterMap, ans, digits, 0, new StringBuilder());
        return ans;
    }

    private void dfs(Map<Character, String> map, List<String> ans, String digits, int depth,
            StringBuilder path) {
        if (path.length() == digits.length()) {
            ans.add(path.toString());
            return;
        }

        char ch = digits.charAt(depth);
        String letters = map.get(ch);
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            dfs(map, ans, digits, depth + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
