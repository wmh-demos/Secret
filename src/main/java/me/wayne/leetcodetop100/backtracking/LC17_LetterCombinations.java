package me.wayne.leetcodetop100.backtracking;

import java.util.ArrayList;
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
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
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

        StringBuilder path = new StringBuilder();
        //递归
        backTracking(path, digitToLetterMap, digits, 0, res);
        return res;
    }

    private void backTracking(StringBuilder path, Map<Character, String> map, String digits,
            int dept, List<String> res) {
        if (digits.length() == dept) {
            res.add(path.toString());
            return;
        }

        char digit = digits.charAt(dept);
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backTracking(path, map, digits, dept + 1, res);
            path.deleteCharAt(dept);
        }
    }
}
