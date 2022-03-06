package me.wayne.leetcodetop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 */
public class LC49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = String.valueOf(arr);

            Integer index = map.get(sortedStr);
            if (index == null) {
                List<String> result = new ArrayList<>();
                result.add(str);
                ans.add(result);
                map.put(sortedStr, ans.size() - 1);
            } else {
                ans.get(index).add(str);
            }
        }

        return ans;
    }
}
