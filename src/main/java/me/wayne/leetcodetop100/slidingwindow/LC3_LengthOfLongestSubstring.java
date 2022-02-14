package me.wayne.leetcodetop100.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 使用滑动窗口的思想来求解
 * 初始化一个辅助哈希表，key是s中的char，value是该char在s中的位置
 * 初始化一个maxLength记录最长字串的长度
 * 当右指针滑动到一个字符时，判断该字符是否在哈希表中出现过
 * 如果出现了，就把左指针移动到刚好能排除这个重复的字符的位置
 */
public class LC3_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, left = 0, right;
        for (right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                // 已重复字符当前下标
                int lastChIndex = map.get(ch);
                // 注意，因为我们不会删除滑动窗口左指针跳过的字符
                // 因此重复的字符并不一定在滑动窗口内，例如abba
                // 而我们要保证滑动窗口的左指针始终在增加，因此要加个判断
                left = Math.max(lastChIndex + 1, left);
            }

            //避免出现左指针回退的情况，所以使用Math.max，如"abba"，右指针滑动到第二个b时，左指针也应该滑动到第二个b
            //然后再滑到到第二个a时，如果不加Math.max，左指针又滑动到第一个b了，不符合预期
            maxLength = Math.max(right - left + 1, maxLength);

            // 将当前字符放到map中
            map.put(ch, right);
        }
        return maxLength;
    }
}
